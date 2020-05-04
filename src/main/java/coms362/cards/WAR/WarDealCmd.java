package coms362.cards.WAR;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.app.ViewFacade;
import coms362.cards.fiftytwo.DealButton;
import coms362.cards.fiftytwo.HideButtonRemote;
import events.remote.CreateRemote;
import events.remote.InsertAtPileBottomRemote;
import events.remote.UpdateRemote;
import model.Card;
import model.Pile;

/**
 * This class deals the cards to both players. 
 * This mostly focuses on the view aspect of the game.
 * 
 * We attempted to try shuffling our cards here, but for some reason
 * it wouldn't show the cards after clicking on the pile if we added
 * some sort of randomness to the pile. So in this implementation,
 * it just simply updates the view for a (mostly) shuffled deck.
 * 
 * We ran short on time due to other classes so we couldn't get a fully
 * shuffled deck. The logic for shuffling would've made more sense here.
 * 
 * @author Jeremy and Madison
 *
 */
public class WarDealCmd implements Move {

	private Table table;
	private Player player;

	public WarDealCmd(Table table, Player player) {
		this.table = table;
		this.player = player;
	}

	@Override
	public void apply(Table table) {
			
		
	}

	@Override
	public void apply(ViewFacade views) {
		try {
			
			String remoteId = views.getRemoteId(DealButton.kSelector);
			views.send(new HideButtonRemote(remoteId));
			Pile p1 = table.getPile("p1"); //grab both piles
			Pile p2 = table.getPile("p2");
			
			
			if (p1 == null || p2 == null) { //ensure neither of them are null
				return;
			}
			for (Card c : p1.cards.values()) { //instantiate pile 1
            	String outVal="";
            	
            	views.send(new CreateRemote(c));
            	views.send(new InsertAtPileBottomRemote("p1", c));
            	views.send(new UpdateRemote(c));
                System.out.println(outVal);	            
	        }
			
			for (Card c2 : p2.cards.values()) { //instantiate pile 2
            	String outVal2="";
            	
            	views.send(new CreateRemote(c2));
            	views.send(new InsertAtPileBottomRemote("p2", c2));
            	views.send(new UpdateRemote(c2));
                System.out.println(outVal2);	            
	        }
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
