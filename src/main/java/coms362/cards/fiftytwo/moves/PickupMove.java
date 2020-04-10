package coms362.cards.fiftytwo.moves;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.app.ViewFacade;
import events.remote.AddToPileRemote;
import events.remote.HideCardRemote;
import events.remote.RemoveFromPileRemote;
import events.remote.ShowCardRemote;
import events.remote.ShowPlayerScore;
import events.remote.view.xform.CameraAtOwnerVis;
import model.Card;

public class PickupMove implements Move {
	
	private Card c;
	private Player p;
	
	public PickupMove(Card c, Player p){
		this.c = c;
		this.p = p; 
	}
	
	public void apply(Table table){
		table.removeFromPile("discardPile", c);
		table.addToPile("Tidy", c);
		table.addToScore(p, 1);
	}
	
	public void apply(ViewFacade view){

		view.send(new HideCardRemote(c));
		view.send(new RemoveFromPileRemote("Random", c));
		view.send(new AddToPileRemote("Tidy", c));
		view.send(new ShowCardRemote(c));
		view.send(new CameraAtOwnerVis(new ShowPlayerScore(p, null)));

	}
	
	
}
