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

public class SP52PUFactory extends P52GameFactory {

	@Override
	public Rules createRules() {
		return new PickupRulesSP();
	}

	@Override
	public Table createTable() {
		return new TableBase(this);
	}
}
