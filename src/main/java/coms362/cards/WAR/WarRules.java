package coms362.cards.WAR;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.fiftytwo.DropEventCmd;
import coms362.cards.fiftytwo.EndPlayMove;
import coms362.cards.fiftytwo.PickupRules;
import coms362.cards.fiftytwo.SetQuorumCmd;
import events.inbound.CardEvent;
import events.inbound.DealEvent;
import events.inbound.InitGameEvent;
import events.inbound.SetQuorumEvent;
import model.Card;
import model.Pile;
import model.Quorum;

/**
 * This class handles all the rules of the game and handles the different type of events 
 * in the game.
 * 
 * @author Jeremy and Madison
 *
 */
public class WarRules extends PickupRules {

	private Table wt = new WarTable(null);

	/**
	 * Here, we intended to use the Wartable as a parameter,
	 * but in our game we never used wartable. Due to the short time we had, 
	 * we never understood how wartable fully worked and could've implemented it 
	 * here to make some of the logic better.
	 * 
	 * @param table - this never gets used
	 */
	public WarRules(Table table) {
		this.wt = table;
	}

	@Override
	public Move apply(SetQuorumEvent e, Table table, Player player) {
		return new SetQuorumCmd(new Quorum(2, 2)); //quorum here is set to two players
	}

	@Override
	public Move apply(InitGameEvent e, Table table, Player player) {

		//changes title to COM S 362 WAR
		return new WarInitCmd(table.getPlayerMap(), "Com S 362 WAR");
	}

	@Override
	public Move apply(DealEvent e, Table table, Player player) {
			
		return new WarDealCmd(table, player); //deals the cards accordingly
	}

	private int a, b;

	@Override
	public Move apply(CardEvent e, Table table, Player player) {

		// decide which card is being selected
		Pile p1 = table.getPile("p1");
		Pile p2 = table.getPile("p2");

		Card x = p1.getCard(e.getId()); //see which card is clicked
		Card y = p2.getCard(e.getId());

		Pile p1s = table.getPile("p1Show"); //get both reveal piles
		Pile p2s = table.getPile("p2Show");

		//see if the first card was picked and player 1 did it
		if (x != null && player.getPlayerNum() == 1) { 
			a = Integer.parseInt(e.getId());
			return new WarFirstShowCmd(p1.getCard(e.getId()), player);
		}

		//see if the second card was picked and player 2 did it
		else if (y != null && player.getPlayerNum() == 2) {
			b = Integer.parseInt(e.getId());
			return new WarSecondShowCmd(p2.getCard(e.getId()), player);
		}

		// winner clicks on their card, and has to first on the next move
		// ensure that both reveal piles aren't empty
		else if (!p1s.cards.isEmpty() && !p2s.cards.isEmpty()) {

			Card c1 = p1s.cards.get(a); //ensure that the correct card is chosen
			Card c2 = p2s.cards.get(b);

			Move move = new SweepCmd(c1, c2, player); //distribute winnings to the winner

			a = p1.cards.size(); //keep track of sizes
			b = p2.cards.size();

			return move;

		}
		
		//win condition, if either player has 52 cards
		else if(p1.cards.size() == 52 || p2.cards.size() == 52 ) {
			
			return new EndPlayMove();
		}

		//otherwise nothing should happen
		return new DropEventCmd();
	}

}
