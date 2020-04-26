package coms362.cards.WAR;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.app.ViewFacade;
import events.remote.RemoveFromPileRemote;
import events.remote.UpdateRemote;
import model.Card;

public class WarSecondShowCmd implements Move{

	
	private Card c;
	private Player p;

	public WarSecondShowCmd(Card c, Player p) {
		this.c = c;
		this.p = p;
	}
	
	@Override
	public void apply(Table table) {
		WarTable table1 = (WarTable) table;
		table1.removeFromPile("p2", c);
		
		
		c.setX(100);
		c.setY(100);
		
	}

	@Override
	public void apply(ViewFacade views) {
		views.send(new RemoveFromPileRemote("p2", c));
		views.send(new UpdateRemote(c));
	}

}
