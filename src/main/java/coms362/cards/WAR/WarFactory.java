package coms362.cards.WAR;

import coms362.cards.abstractcomp.Rules;
import coms362.cards.abstractcomp.Table;
import coms362.cards.fiftytwo.P52GameFactory;
import model.TableBase;

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
