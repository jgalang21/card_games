package coms362.cards.app;

import java.util.Arrays;
import java.util.List;

import coms362.cards.abstractcomp.GameFactory;
import coms362.cards.fiftytwo.P52GameFactory;
import coms362.cards.sp_pickup.P52SPGameFactory;


public class GameFactoryFactory {

	// TODO: create Enum for game ids. 
	String gameIds[] = {"PU52MP", "PU52"};
	List<String> supported = Arrays.asList(gameIds);
	
	public GameFactory getGameFactory(String selector){
		switch (selector){
		case "PU52MP" :
			return new P52GameFactory();
		case "PU52" : 
			return new P52SPGameFactory();	
		default:
			return null;
		}
	}

	public boolean isValidSelection(String gameId) {
		return supported.contains(gameId);
	}
}
