package coms362.cards.PU52SP;

import coms362.cards.abstractcomp.Rules;
import coms362.cards.fiftytwo.P52GameFactory;

public class P52SPGameFactory extends P52GameFactory {
	
	@Override
	public Rules createRules(){
		return new SinglePickupRules();
	}
}
