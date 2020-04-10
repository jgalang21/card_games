package coms362.cards.app;

import java.util.Arrays;
import java.util.List;

import coms362.cards.PU52SP.P52SPGameFactory;
import coms362.cards.abstractcomp.GameFactory;
import coms362.cards.fiftytwo.P52GameFactory;
import coms362.cards.mix.MixGameFactory;


public class GameFactoryFactory {
	
	String gameIds[] = {"PU52MP", "PU52", "test"};
	List<String> supported = Arrays.asList(gameIds);
	
	public GameFactory getGameFactory(String selector){
		switch (selector){
		case "PU52MP": 
			return new P52GameFactory();
		case "PU52":
			return new P52SPGameFactory();
		case "test":
			return new MixGameFactory();
		default:
			System.exit(-1);	
			
		}
		return null;		
	}

	public boolean isValidSelection(String gameId) {
		return supported.contains(gameId);
	}
}
