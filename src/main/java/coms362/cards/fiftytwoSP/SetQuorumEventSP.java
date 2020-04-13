package coms362.cards.fiftytwoSP;
import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.RulesDispatch;
import coms362.cards.abstractcomp.Table;
import events.inbound.*;
import model.Quorum;

public class SetQuorumEventSP extends SetQuorumEvent{

Quorum quorum = null; 
	
	public SetQuorumEventSP(String min, String max) {
		super(min, max);
		this.quorum = new Quorum(1,1);
	}

	public SetQuorumEventSP(Quorum quorum) {
		super(quorum);
		this.quorum = quorum;
	}

	@Override
	public Move dispatch(RulesDispatch rules, Table table, Player player) {
		return rules.apply(this, table, player);
	}

	public Quorum getQuorum() {
		return quorum;
	}
}
