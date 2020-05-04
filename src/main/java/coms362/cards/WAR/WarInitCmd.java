package coms362.cards.WAR;

import java.util.Map;
import java.util.Random;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.app.ViewFacade;
import coms362.cards.fiftytwo.DealButton;
import events.remote.CreateButtonRemote;
import events.remote.CreatePile;
import events.remote.SetBottomPlayerTextRemote;
import events.remote.SetGameTitleRemote;
import events.remote.SetupTable;
import model.Card;
import model.Location;
import model.Pile;

/**
 * This class instantiates the piles and (mostly) shuffles them. 
 * (see WarDealCmd.java documentation for more on shuffling)
 * 
 * There are four piles in total. 
 * 
 * p1 and p2 are the main piles where all of the player's cards are selected
 * 
 * p1Show and p2Show are the temporary piles where players reveal the cards they have
 * 
 * 
 * @author Jeremy and Madison
 *
 */
public class WarInitCmd implements Move {

	private Map<Integer, Player> players;
	private String title;

	// player 1's main pile
	private Pile p1 = new Pile("p1", new Location(300, 510));

	// player 1 reveal pile
	private Pile p1Show = new Pile("p1Show", new Location(300, 400));

	// player 2's main pile
	private Pile p2 = new Pile("p2", new Location(300, 100));

	// player 2's reveal pile
	private Pile p2Show = new Pile("p2Show", new Location(300, 200));

	public WarInitCmd(Map<Integer, Player> players, String title) {
		this.players = players;
		this.title = title;
	}

	@Override
	public void apply(Table table) {

		Random rand = new Random();

		try {
			for (String suit : Card.suits) {
				for (int i = 1; i <= 13; i++) {
					Card card = new Card();
					card.setSuit(suit);
					card.setNumber(i);
					card.setFaceUp(false);
					card.setRotate(0);

					// randomly distribute cards to either pile
					// shuffling in wardeal didn't seem to work, see comments in WarDealCmd.java
					int x = rand.nextInt(100);

					if (p1.cards.size() != 26 && x % 2 == 1) {
						card.setX(p1.getLocation().getX()); //place the card at the deck
						card.setY(p1.getLocation().getY());
						p1.cards.put(card.getId(), card);
					} else { // put the rest in the other player's pile

						card.setX(p2.getLocation().getX());
						card.setY(p2.getLocation().getY());
						p2.cards.put(card.getId(), card);
					}

				}
			}

			//add all the piles to the table
			table.addPile(p1);
			table.addPile(p2);
			table.addPile(p1Show);
			table.addPile(p2Show);
			
			
			//set ONLY the reveal piles to be faceup
			p1Show.setFaceUp(true);
			p2Show.setFaceUp(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void apply(ViewFacade view) {
		view.send(new SetupTable());
		view.send(new SetGameTitleRemote(title));

		for (Player p : players.values()) {
			String text = "Player " + p.getPlayerNum();
			view.send(new SetBottomPlayerTextRemote(text, p));
		}

		view.send(new CreatePile(p1));
		view.send(new CreatePile(p2));
		view.send(new CreatePile(p1Show));
		view.send(new CreatePile(p2Show));
		String id = "";
		DealButton dealButton = new DealButton("DEAL", new Location(0, 0));
		view.register(dealButton); // so we can find it later.
		view.send(new CreateButtonRemote(dealButton));

	}

}
