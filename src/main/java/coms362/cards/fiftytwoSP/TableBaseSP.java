package coms362.cards.fiftytwoSP;

import java.util.HashMap;
import java.util.Map;

import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import model.PlayerFactory;
import model.Quorum;
import model.TableBase;

public class TableBaseSP extends TableBase implements Table {

	public TableBaseSP(PlayerFactory pFactory) {
		super(pFactory);
		// TODO Auto-generated constructor stub
	}


	//private Map<Integer, Player> players = new HashMap<Integer, Player>();


	@Override
	public boolean partiesReady() {
		
		return quorum != null && quorum.meets(1);
	}

	@Override
	public Quorum getQuorum() {
		return quorum;
	}

	@Override
	public void setQuorum(Quorum quorum) {
		this.quorum = quorum;		
	}
}
