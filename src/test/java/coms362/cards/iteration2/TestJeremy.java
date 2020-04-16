package coms362.cards.iteration2;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.fiftytwo.PickupPlayer;
import coms362.cards.fiftytwo.PickupRules;
import coms362.cards.fiftytwo.SetQuorumCmd;
import coms362.cards.fiftytwoSP.PickupRulesSP;
import events.inbound.SetQuorumEvent;
import model.PlayerFactory;
import model.Quorum;
import model.TableBase;

/**
 * Test Classes for iteration 2
 * 
 * @author Jeremy Galang
 *
 */
public class TestJeremy
{

	@Test
	public void testJeremy()
	{
		PlayerFactory f = null;
		SetQuorumEvent x = new SetQuorumEvent("10", "10");
		Table t = new TableBase(f);
		Player p = new PickupPlayer(1);
		
		PickupRules r = new PickupRulesSP();
		Move check = r.apply(x, t, p);
		
		Quorum quo = new Quorum(10,10);
		SetQuorumCmd setQ = new SetQuorumCmd(quo);
		
		assertEquals(check, setQ);
		
		
		

	}

	

	

}

