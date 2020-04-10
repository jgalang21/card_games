package coms362.cards.mix;

import coms362.cards.abstractcomp.GameFactory;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Rules;
import coms362.cards.abstractcomp.Table;
import coms362.cards.abstractcomp.View;
import coms362.cards.fiftytwo.P52GameFactory;
import coms362.cards.fiftytwo.PartyRole;
import coms362.cards.streams.RemoteTableGateway;
import model.PlayerFactory;
import model.Quorum;
import model.TableBase;

public class MixGameFactory extends P52GameFactory
implements GameFactory {

	@Override
	public Rules createRules() {
		return new MixGameRules();
	}
	
	@Override
	public Table createTable() {
		Table rval = new TableBase(this);
		rval.setQuorum(new Quorum(2,2));
		return rval;
	}
}
