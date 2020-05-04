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

/**
 * This class determines the winner of the game, it compares both player's 
 * show piles, and puts them at the bottom of the winner's deck.
 * 
 * @author Jeremy and Madison
 *
 */
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
		
		
		//remove the two cards from both player's show pile
		table.removeFromPile("p1Show", c1);
		table.removeFromPile("p2Show", c2);
		
		
		//if the value of the first card is bigger than the second
		if(c1.getNumber() > c2.getNumber()) {
			
			table.addToPile("p1", c1);
			table.addToPile("p1", c2);
			winner = "p1";
		}
		
		//if the second card is bigger than the first
		else if( c1.getNumber() < c2.getNumber()) {

			table.addToPile("p2", c1);
			table.addToPile("p2", c2);
			winner = "p2";
		}
		
		//otherwise, add it to player 1's pile by default
		else {
			table.addToPile("p1", c1);
			table.addToPile("p1", c2);
			winner = "p1";
		}	
		
	}

	@Override
	public void apply(ViewFacade views) {

		//remove the show piles from the view
		views.send(new RemoveFromPileRemote("p1Show", c1));
		views.send(new RemoveFromPileRemote("p2Show", c2));
		
		//if p1 won, put it at the bottom of their deck
		if(winner.equals("p1")) {
			views.send(new InsertAtPileTopRemote(winner, c1)); //inverted
			views.send(new InsertAtPileTopRemote(winner, c2)); 
			
		}
		else { //otherwise put it at the bottom of p2's deck
			views.send(new InsertAtPileTopRemote(winner, c1)); //inverted
			views.send(new InsertAtPileTopRemote(winner, c2)); 
		}
		
		//update the remote
		views.send(new UpdateRemote(c1));
		views.send(new UpdateRemote(c2));
	}

	
	
}
