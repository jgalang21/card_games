package coms362.cards.fiftytwoSP;

import coms362.cards.abstractcomp.GameFactory;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Rules;
import coms362.cards.abstractcomp.Table;
import coms362.cards.abstractcomp.View;
import coms362.cards.abstractcomp.ViewFactory;
import coms362.cards.fiftytwo.P52GameFactory;
import coms362.cards.fiftytwo.PickupRules;
import coms362.cards.streams.RemoteTableGateway;
import model.PlayerFactory;
import model.TableBase;


/**
 * This class simply extends the 52PU Gamefactory, the only difference is that it uses single player pickup rules.
 * 
 * @author Jeremy and Madison
 *
 */
public class SP52PUFactory extends P52GameFactory {

	
	/**
	 * Create a new set of single player pickup rules. 
	 */
	@Override
	public Rules createRules() {
		return new PickupRulesSP();
	}

}
