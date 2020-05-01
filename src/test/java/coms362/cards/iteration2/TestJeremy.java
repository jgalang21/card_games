package coms362.cards.iteration2;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import coms362.cards.abstractcomp.GameFactory;
import coms362.cards.abstractcomp.Rules;
import coms362.cards.app.GameFactoryFactory;
import coms362.cards.fiftytwo.P52GameFactory;
import coms362.cards.fiftytwo.PickupRules;
import coms362.cards.fiftytwoSP.PickupRulesSP;
import coms362.cards.fiftytwoSP.SP52PUFactory;
import events.remote.AddToPileRemote;
import events.remote.ShowCardRemote;
import model.Button;
import model.Card;
import model.Deck;
import model.Location;
import model.PlayerFactory;
import model.Quorum;

/**
 * Test Classes for iteration 2
 * 
 * These tests both ensure that the singleplayer and mutliplayer features still
 * work properly.
 * 
 * @author Jeremy Galang
 *
 */
public class TestJeremy {

	// Global game factory, showing that both can still switch between single and
	// multiplayer.
	GameFactoryFactory gff = new GameFactoryFactory();

	@Test
	public void testJeremy() {

		// Create a new single player PU52 instance
		GameFactory temp = gff.getGameFactory("PU52");

		// Create the new singleplayer rules
		Rules x = temp.createRules();

		// ensure that the new variables being created are an instance of the new
		// classes
		assertTrue(temp instanceof SP52PUFactory);
		assertTrue(x instanceof PickupRulesSP);
	}

	@Test
	public void testJeremy2() {

		// Create a new multiplayer player PU52 instance,ensure that it still works
		GameFactory temp = gff.getGameFactory("PU52MP");

		// Create the existing multiplayer rules
		Rules x = temp.createRules();

		// ensure that the new variables being created are an instance of the new
		// classes
		assertTrue(temp instanceof P52GameFactory);
		assertTrue(x instanceof PickupRules);

	}

	// these test are simply the ones I wrote up about in the code coverage analysis

	@Test
	public void testJeremy3() {

		// these test some of the classes in the model package
		Quorum x = new Quorum(1, 1);

		assertEquals(true, x.meets(1));
		assertEquals(false, x.exceeds(0)); // it shouldn't have anything yet

		Location loc = new Location(10, 10);

		Deck deck = new Deck("Deck", loc);

		assertEquals(10, deck.getLocation().getX());
		assertEquals(10, deck.getLocation().getY());

		Button but = new Button("Selector", "Event", "Lablel", loc);

		but.setEvtName("Name");
		but.setLabel("Label");
		but.setLocation(loc);

		assertEquals("Name", but.getEvtName());
		assertEquals("Label", but.getLabel());
		assertEquals(loc, but.getLocation());

		// these test some of the classes in the events.remote package
		Card card = new Card();

		ShowCardRemote rc = new ShowCardRemote(card);

		// verify that these methods are working as intended, contents may not be
		// accurate
		assertNotNull(rc.marshall());
		assertNotNull(rc.stringify());

		AddToPileRemote apc = new AddToPileRemote("TestName", card);

		assertNotNull(apc.marshall());
		assertNotNull(apc.stringify());

		// one test case that uses the coms362.cards.fiftytwo package
		P52GameFactory pgf = new P52GameFactory();

		assertTrue(pgf.createPlayerFactory() instanceof PlayerFactory);

	}

}
