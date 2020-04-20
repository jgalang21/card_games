package coms362.cards.coordinates;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestAbstractCoordinate {
	
	public Point p;
	
	@Before 
	public void setup(){
		p = new Point(255, 240);
	}

	@Test
	public void testCtor() {
		assertEquals( 255, p.x);
		assertEquals( 240, p.y);
	}
	
	String expectedCC = 
		"0:-240,255|"+
		"1:-255,-240|"+
		"2:240,-255|"+
		"3:255,240|";
	
	@Test
	public void testCcRotate() {
		String log = ""; 
		for (int i = 0; i < 4; i++){
			p = p.rotate90cc();
			log += String.format("%d:%d,%d|", i, p.x, p.y);
		}
		System.out.println(log);
		assertEquals(expectedCC,log);
	}

	String expected = "0:240,-255|1:-255,-240|2:-240,255|3:255,240|";
	@Test
	public void testRotate() {
		String log = ""; 
		for (int i = 0; i < 4; i++){
			p = p.rotate90();
			log += String.format("%d:%d,%d|", i, p.x, p.y);
		}
		System.out.println(log);
		assertEquals(expected,log);
	}
	
	String expected4Pos = "1:255,240|2:-240,255|3:-255,-240|4:240,-255|";
	@Test
	public void testRotateToPos() {
		String log = "";
		
		for (int i = 1; i <= 4; i++){
			Point rView = p.rotateToPos(i);
			log += String.format("%d:%d,%d|", i, rView.x, rView.y);
		}
		System.out.println(log);
		assertEquals(expected4Pos,log);
	}

	

}
