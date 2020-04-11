package coms362.cards.fiftytwoSP;

import model.PlayerFactory;
import model.Quorum;
import model.TableBase;

public class TableBaseSP extends TableBase {

	private Quorum quorum = null; 
	
	public TableBaseSP(PlayerFactory pFactory) {
		super(pFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean partiesReady() {
		return quorum != null && quorum.meets(1);
	}


}
