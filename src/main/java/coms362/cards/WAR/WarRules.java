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
	
	private int a, b;

	@Override
	public Move apply(CardEvent e, Table table, Player player) {

		//decide which card is being selected
				
		Pile p1 = table.getPile("p1");
		Pile p2 = table.getPile("p2");

		Pile p1s = table.getPile("p1Show");
		Pile p2s = table.getPile("p2Show");
		
		// if the show pile is empty, take it from p1's main deck
		if (p1s.cards.isEmpty()) {
			a = Integer.parseInt(e.getId());
			return new WarFirstShowCmd(p1.getCard(e.getId()), player);
		}

		// if the show pile is empty, take it from p2's main deck
		else if (p2s.cards.isEmpty()) {
			b = Integer.parseInt(e.getId());
			return new WarSecondShowCmd(p2.getCard(e.getId()), player);
		}

		// winner clicks on their card
		else if (!p1s.cards.isEmpty() && !p2s.cards.isEmpty()) {
			
			//System.out.println("============" + a + b);
			
			if(p1s.cards.get(a).getNumber() == p2s.cards.get(b).getNumber()) {
				
				
				System.out.println("============");
				System.out.println(a);
				System.out.println(b);
				System.out.println("============");
				b--;
				a++;
				
				System.out.println("============");
				System.out.println(a);
				System.out.println(b);
				System.out.println("============");
			}
			
//			if (temp.getNumber() == temp2.getNumber()) {
//				return new SweepCmd(temp, temp2, player);
//			}

			// update i and j accordingly
		}

		return new DropEventCmd();
	}

}
