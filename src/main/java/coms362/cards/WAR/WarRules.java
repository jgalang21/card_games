package coms362.cards.WAR;

import java.util.HashMap;
import java.util.Map;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.fiftytwo.DealCommand;
import coms362.cards.fiftytwo.DropEventCmd;
import coms362.cards.fiftytwo.PickupInitCmd;
import coms362.cards.fiftytwo.PickupMove;
import coms362.cards.fiftytwo.PickupRules;
import coms362.cards.fiftytwo.SetQuorumCmd;
import events.inbound.CardEvent;
import events.inbound.DealEvent;
import events.inbound.InitGameEvent;
import events.inbound.SetQuorumEvent;
import model.Card;
import model.Pile;
import model.Quorum;

public class WarRules extends PickupRules {
	/**
	 * This defaults to creating a new Quorum object with 1,1
	 */
	private Table wt;
	private int i = 26;
	private int j = 52; 

	public WarRules(Table table) {
		this.wt = table;
	}
	

	@Override
	public Move apply(SetQuorumEvent e, Table table, Player player) {
		return new SetQuorumCmd(new Quorum(1, 1));
	}

	@Override
	public Move apply(InitGameEvent e, Table table, Player player) {

		Player p1 = table.getPlayer((Integer) 1);

		return new WarInitCmd(table.getPlayerMap(), "Com S 362 WAR");
	}

	@Override
	public Move apply(DealEvent e, Table table, Player player) {
		return new WarDealCmd(table, player);
	}

	@Override
	public Move apply(CardEvent e, Table table, Player player) {

		Card c = table.getPile("p1").getCard(e.getId());
		Card c2 = table.getPile("p2").getCard(e.getId());
		Pile p1 = table.getPile("p1Show");
		Pile p2 = table.getPile("p2Show");

		// if the first card is chosen
		if (c != null && c2 == null) {
			return new WarFirstShowCmd(c, player);
		}

		// if the second card is chosen
		else if (c == null && c2 != null) {
			return new WarSecondShowCmd(c2, player);
		}
		
		//winner clicks on their card
		else if (p1.cards.size() == 1 && p2.cards.size() == 1) {
			Card temp = p1.cards.get(i);
			Card temp2 = p2.cards.get(j);
			
			if(temp.getNumber() == temp2.getNumber()) {
				return new SweepCmd(temp, temp2, player);
			}
			
			
			
			
			//update i and j accordingly
		}

		return new DropEventCmd();
	}

}
