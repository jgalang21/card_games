package coms362.cards.WAR;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.app.ViewFacade;
import events.remote.CreateRemote;
import events.remote.HideCardRemote;
import events.remote.InsertAtPileBottomRemote;
import events.remote.InsertAtPileTopRemote;
import events.remote.RemoveFromPileRemote;
import events.remote.ShowCardRemote;
import events.remote.ShowPlayerScore;
import events.remote.UpdateRemote;
import model.Card;

/**
 * This class is meant for player 1. This move is when player 1 clicks on their
 * main deck, and it will reveal it in their reveal pile.
 * 
 * @author Jeremy and Madison
 *
 */
public class WarFirstShowCmd implements Move{
	
	private Card c;
	private Player p;

	public WarFirstShowCmd(Card c, Player p) {
		this.c = c;
		this.p = p;
	}
	
	
	@Override
	public void apply(Table table) {
		
		//remove the card from the main pile
		table.removeFromPile("p1", c);
		
		//add the card to the reveal pile
		table.addToPile("p1Show", c);
			
	}

	@Override
	public void apply(ViewFacade views) {
		

		//this just updates the view 
		views.send(new HideCardRemote(c));
		views.send(new RemoveFromPileRemote("p1", c));
		views.send(new InsertAtPileBottomRemote("p1Show", c)); //inverted
		views.send(new ShowCardRemote(c));
		

	}

}
