package coms362.cards.fiftytwoSP;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.fiftytwo.PickupInitCmd;
import coms362.cards.fiftytwo.PickupRules;
import coms362.cards.fiftytwo.SetQuorumCmd;
import events.inbound.InitGameEvent;
import events.inbound.SetQuorumEvent;
import model.Quorum;

public class PickupRulesSP extends PickupRules {

	
	
	@Override
	public Move apply(SetQuorumEvent e, Table table, Player player){
		return new SetQuorumCmd(new Quorum(1, 1));
	}
	
	
	@Override
	public Move apply(InitGameEvent e, Table table, Player player){
		Player p1 = table.getPlayer((Integer) 1);
	//	Player p2 = table.getPlayer((Integer) 2); 
		
		return new PickupInitCmd(table.getPlayerMap());
	}
}
