package coms362.cards.iteration2;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import model.Quorum;

/**
 * Test Case for Iteration 2
 * @author Madison Kriege
 */
public class TestMadison {
	
	@Test
	public void quorumSetTest() {
		Quorum quorumInt = new Quorum(1,1);
		assertEquals(true, quorumInt.isSet());
		
		Quorum quorumString = new Quorum("2", "4");
		assertEquals(true, quorumString.isSet());
	}
	
	@Test
	public void quorumExceedsTest() {
		Quorum quorumExceeds = new Quorum(1,5);
		assertEquals(true, quorumExceeds.exceeds(10));
	}
	
	@Test
	public void quorumMeetsTest() {
		Quorum quorumMax = new Quorum(1,5);
		assertEquals(true, quorumMax.meets(5));
		
		Quorum quorumMin = new Quorum(5,10);
		assertEquals(true, quorumMin.meets(5));
	}
}
