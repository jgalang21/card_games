package coms362.cards.WAR;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.app.ViewFacade;
import events.remote.HideCardRemote;
import events.remote.InsertAtPileBottomRemote;
import events.remote.InsertAtPileTopRemote;
import events.remote.RemoveFromPileRemote;
import events.remote.SetBottomPlayerTextRemote;
import events.remote.ShowCardRemote;
import events.remote.UpdateRemote;
import model.Card;
import model.Pile;

public class SweepCmd implements Move {
	
	private Card c1;
	private Card c2; 

	private String winner;
	private Player p;
	
	
	public SweepCmd(Card c1, Card c2, Player p) {
		this.c1 = c1;
		this.c2 = c2;
		this.p = p;
	}

	@Override
	public void apply(Table table) {
		
		
		if(p.getPlayerNum() == 1) {
		
			table.removeFromPile("p1Show", c1);
			table.removeFromPile("p2Show", c2);
			table.addToPile("p1", c1);
			table.addToPile("p1", c2);
			winner = "p1";
			
		}
		else {
			table.removeFromPile("p1Show", c1);
			table.removeFromPile("p2Show", c2);
			table.addToPile("p2", c1);
			table.addToPile("p2", c2);
			winner = "p2";
		}	
		
	}

	@Override
	public void apply(ViewFacade views) {

		views.send(new RemoveFromPileRemote("p1Show", c1));
		views.send(new RemoveFromPileRemote("p2Show", c2));
		
		if(winner.equals("p1")) {
			views.send(new InsertAtPileTopRemote("p1", c1)); //inverted
			views.send(new InsertAtPileTopRemote("p1", c2)); 
			
		}
		else {
			views.send(new InsertAtPileTopRemote("p2", c1)); //inverted
			views.send(new InsertAtPileTopRemote("p2", c2)); 
		}
		
		views.send(new UpdateRemote(c1));
		views.send(new UpdateRemote(c2));
	}

}
