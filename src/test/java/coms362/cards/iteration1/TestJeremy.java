package coms362.cards.iteration1;

import static org.junit.Assert.*;

import org.junit.Test;

import coms362.cards.abstractcomp.Table;
import coms362.cards.fiftytwo.PickupMove;
import coms362.cards.socket.SocketEvent;
import coms362.cards.streams.InBoundQueue;
import coms362.cards.streams.RemoteTableGateway;
import events.inbound.ConnectEvent;
import events.inbound.DealEvent;
import events.inbound.EndPlay;
import model.Card;
import model.Location;
import model.Pile;
import model.TableBase;

/**
 * Test Classes
 * 
 * @author Jeremy Galang
 *
 */
public class TestJeremy
{

	@Test
	public void testJeremy()
	{

		Location loc = new Location(5, 5); // create a location at 5,5

		Pile p = new Pile("Jeremy", loc); // create a pile named Jeremy with said location

		Location verify = new Location(5, 5); // a temporary location for unit testing

		assertEquals(verify.getX(), p.getLocation().getX());
		assertEquals(verify.getY(), p.getLocation().getY());

		// Verifies the location of where the piles are.

	}

	@Test
	public void testJeremy2()
	{

		// create a new card and test its functionality.

		Card c = new Card();
		c.setSuit("Heart");
		c.setNumber(4);
		c.setX(10);
		c.setY(10);
		c.setFaceUp(true);

		// verify its attributes
		assertEquals("Heart", c.getSuit());
		assertEquals(4, c.getNumber());
		assertEquals(10, c.getX());
		assertEquals(10, c.getY());
		assertEquals(true, c.isFaceUp());

	}

	@Test
	public void testJeremy3()
	{

		Location loc = new Location(50, 50); // create a location at 50,50

		Pile p = new Pile("Jeremy", loc); // create a pile named Jeremy with said location
		Pile p2 = new Pile("Jeremy2", loc); // create a pile named Jeremy2 with said location

		Location verify = new Location(50, 50); // a temporary location for unit testing
		Location verify2 = new Location(50, 50);

		assertEquals(verify.getX(), p.getLocation().getX());
		assertEquals(verify.getY(), p.getLocation().getY());

		assertEquals(verify2.getX(), p2.getLocation().getX());
		assertEquals(verify2.getY(), p2.getLocation().getY());

		// Verifies the location of where multiple piles are.

	}

}
