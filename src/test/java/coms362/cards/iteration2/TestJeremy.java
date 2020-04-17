package coms362.cards.iteration2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import coms362.cards.abstractcomp.GameFactory;
import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Rules;
import coms362.cards.abstractcomp.Table;
import coms362.cards.app.GameController;
import coms362.cards.app.GameFactoryFactory;
import coms362.cards.fiftytwo.P52GameFactory;
import coms362.cards.fiftytwo.PickupPlayer;
import coms362.cards.fiftytwo.PickupRules;
import coms362.cards.fiftytwo.SetQuorumCmd;
import coms362.cards.fiftytwo.TestEndpoint;
import coms362.cards.fiftytwo.TestGFF;
import coms362.cards.fiftytwo.TestGameFactory;
import coms362.cards.fiftytwoSP.PickupRulesSP;
import coms362.cards.fiftytwoSP.SP52PUFactory;
import coms362.cards.socket.SocketEvent;
import coms362.cards.streams.InBoundQueue;
import coms362.cards.streams.RemoteTableGateway;
import events.inbound.ConnectEvent;
import events.inbound.DealEvent;
import events.inbound.EndPlay;
import events.inbound.SetQuorumEvent;
import model.PlayerFactory;
import model.Quorum;
import model.TableBase;

/**
 * Test Classes for iteration 2
 * 
 * These tests both ensure that the singleplayer and mutliplayer features 
 * still work properly.
 * 
 * @author Jeremy Galang
 *
 */
public class TestJeremy {

	
	//Global game factory, showing that both can still switch between single and multiplayer.
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
	
	
	

	
}
