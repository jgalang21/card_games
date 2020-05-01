package coms362.cards.WAR;

import coms362.cards.abstractcomp.Rules;
import coms362.cards.abstractcomp.Table;
import coms362.cards.fiftytwo.P52GameFactory;
import model.TableBase;

/**
 * This WarFactory creates the rules and the tables for the war game.
 * 
 * @author Jeremy and Madison
 *
 */
public class WarFactory extends P52GameFactory{
	
	@Override
	public Rules createRules() {
		return new WarRules(createTable());
	}
	
	@Override
	public Table createTable() {
		return new WarTable(this);
	}
	

}
