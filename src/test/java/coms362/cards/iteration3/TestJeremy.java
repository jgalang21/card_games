package coms362.cards.iteration3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import coms362.cards.WAR.WarFactory;
import coms362.cards.WAR.WarFirstShowCmd;
import coms362.cards.WAR.WarRules;
import coms362.cards.WAR.WarSecondShowCmd;
import coms362.cards.abstractcomp.GameFactory;
import coms362.cards.abstractcomp.Rules;
import coms362.cards.abstractcomp.Table;
import coms362.cards.app.GameFactoryFactory;
import coms362.cards.fiftytwo.P52GameFactory;
import coms362.cards.fiftytwo.PickupRules;
import coms362.cards.fiftytwoSP.PickupRulesSP;
import coms362.cards.fiftytwoSP.SP52PUFactory;
import model.Card;
import model.Location;
import model.Pile;

public class TestJeremy {
	
	
	//Ensure that all games still work
	@Test
	public void testGames() {
		
		GameFactoryFactory gff = new GameFactoryFactory();
		GameFactory temp = gff.getGameFactory("WAR");
		
		Rules r = temp.createRules();
		
		assertTrue(temp instanceof WarFactory);
		assertTrue(r instanceof WarRules);
	
		
		GameFactory temp2 = gff.getGameFactory("PU52");
		Rules r2 = temp2.createRules();
		
		assertTrue(temp2 instanceof SP52PUFactory);
		assertTrue(r2 instanceof PickupRulesSP);
		
		GameFactory temp3 = gff.getGameFactory("PU52");
		Rules r3 = temp3.createRules();
		
		assertTrue(temp3 instanceof P52GameFactory);
		assertTrue(r3 instanceof PickupRules);
		
	}
	
	
	//Ensure that player 1 putting a card in their main deck to reveal deck works
	@Test
	public void testFirstShows() {
		
		GameFactoryFactory gff = new GameFactoryFactory();
		GameFactory temp = gff.getGameFactory("WAR");
		
		Table t = temp.createTable();
		 
		
		t.addPile(new Pile("p1", new Location(400,400)));
		t.addPile(new Pile("p1Show", new Location(400,400)));

		Card c = new Card();
		c.setNumber(1);
		
		WarFirstShowCmd x = new WarFirstShowCmd(c, null);
		x.apply(t);
		
		assertEquals(1, t.getPile("p1Show").cards.size());
		
		
	}
	
	//Ensure that player 2 putting a card in their main deck to reveal deck works
	@Test
	public void testSecondShows() {
		
		GameFactoryFactory gff = new GameFactoryFactory();
		GameFactory temp = gff.getGameFactory("WAR");
		
		Table t = temp.createTable();
		 
		
		t.addPile(new Pile("p2", new Location(400,400)));
		t.addPile(new Pile("p2Show", new Location(400,400)));

		Card c = new Card();
		c.setNumber(1);
		
		WarSecondShowCmd x = new WarSecondShowCmd(c, null);
		x.apply(t);
		
		assertEquals(1, t.getPile("p2Show").cards.size());
		
		
	}
	
	

}
