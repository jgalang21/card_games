package coms362.cards.app;

import java.util.Arrays;
import java.util.List;

import coms362.cards.abstractcomp.GameFactory;
import coms362.cards.fiftytwo.P52GameFactory;
import coms362.cards.fiftytwoSP.SP52PUFactory;


public class GameFactoryFactory {
	
	String gameIds[] = {"PU52MP", "PU52"};
	List<String> supported = Arrays.asList(gameIds);
	
	public GameFactory getGameFactory(String selector){
		
		if(selector.equals("PU52MP")) {
			return new P52GameFactory();
		}
		else {
			return new SP52PUFactory();
		}
	}

	public boolean isValidSelection(String gameId) {
		return supported.contains(gameId);
	}
}
