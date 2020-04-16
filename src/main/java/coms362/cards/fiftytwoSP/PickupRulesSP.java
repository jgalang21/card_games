package coms362.cards.fiftytwoSP;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Rules;
import coms362.cards.abstractcomp.Table;
import coms362.cards.fiftytwo.CreatePlayerCmd;
import coms362.cards.fiftytwo.DropEventCmd;
import coms362.cards.fiftytwo.PartyRole;
import coms362.cards.fiftytwo.PickupInitCmd;
import coms362.cards.fiftytwo.PickupRules;
import coms362.cards.fiftytwo.SetQuorumCmd;
import events.inbound.ConnectEvent;
import events.inbound.InitGameEvent;
import events.inbound.NewPartyEvent;
import events.inbound.SetQuorumEvent;
import model.Quorum;


/**
 * This class simply just creates new pickup rules for the single player game.
 * 
 * @author Jeremy and Madison
 *
 */
public class PickupRulesSP extends PickupRules 
{
	
	/**
	 * This defaults to creating a new Quorum object with 1,1
	 */
	@Override
	public Move apply(SetQuorumEvent e, Table table, Player player){
		return new SetQuorumCmd(new Quorum(1, 1));
	}
	
	
	/**
	 * Create a new PickupInitCmd, with the singleplayer title.
	 * 
	 * Pickupinitcmd now takes in a string, Robert mentioned to do this
	 * in class (4/15)
	 */
	@Override
	public Move apply(InitGameEvent e, Table table, Player player){
	
		Player p1 = table.getPlayer((Integer) 1);
		
		return new PickupInitCmd(table.getPlayerMap(), "52 Card Pickup SinglePlayer");
	}
	
}
