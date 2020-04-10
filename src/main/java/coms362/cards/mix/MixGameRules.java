package coms362.cards.mix;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Rules;
import coms362.cards.abstractcomp.Table;
import coms362.cards.fiftytwo.DropEventCmd;
import coms362.cards.fiftytwo.PartyRole;
import coms362.cards.fiftytwo.PickupRules;
import coms362.cards.fiftytwo.moves.CreatePlayerCmd;
import coms362.cards.fiftytwo.moves.PickupInitCmd;
import coms362.cards.fiftytwo.moves.SetQuorumCmd;
import events.inbound.ConnectEvent;
import events.inbound.DealEvent;
import events.inbound.InitGameEvent;
import events.inbound.SetQuorumEvent;
import model.Quorum;

public class MixGameRules extends PickupRules
implements Rules 
{

	@Override
	public Move apply(InitGameEvent e, Table table, Player player){
		return new MixInitCmd(table.getPlayerMap(), "Mix Of Tests");
	}

	@Override
	public Move apply(DealEvent e, Table table, Player player){
		return new MixDealCommand(table, player);
	}	
	
	@Override
	public Move apply(SetQuorumEvent e, Table table, Player player){
		return new SetQuorumCmd(new Quorum(4,4));
	}
	
}
