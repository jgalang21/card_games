package coms362.cards.WAR;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.app.ViewFacade;
import events.remote.HideCardRemote;
import events.remote.InsertAtPileBottomRemote;
import events.remote.InsertAtPileTopRemote;
import events.remote.RemoveFromPileRemote;
import events.remote.ShowCardRemote;
import events.remote.ShowPlayerScore;
import events.remote.UpdateRemote;
import model.Card;

public class WarSecondShowCmd implements Move{

	
	private Card c;
	private Player p;

	public WarSecondShowCmd(Card c, Player p) {
		this.c = c;
		this.p = p;
	}
	
	@Override
	public void apply(Table table) {
		
		table.removeFromPile("p2", c);
		table.addToPile("p2Show", c);
		
	}

	@Override
	public void apply(ViewFacade views) {
	
		//views.send(new ShowCardRemote(c));
		views.send(new HideCardRemote(c));
		views.send(new RemoveFromPileRemote("p2", c));
		views.send(new InsertAtPileBottomRemote("p2Show", c));
		views.send(new ShowCardRemote(c));
		//views.send(new UpdateRemote(c));
	
		
		
		
		
	}

}
