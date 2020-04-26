package coms362.cards.WAR;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.app.ViewFacade;
import events.remote.RemoveFromPileRemote;
import events.remote.UpdateRemote;
import model.Card;

public class WarFirstShowCmd implements Move{
	
	private Card c;
	private Player p;

	public WarFirstShowCmd(Card c, Player p) {
		this.c = c;
		this.p = p;
	}
	
	
	@Override
	public void apply(Table table) {
		WarTable table1 = (WarTable) table;
		table1.removeFromPile("p1", c);
		
		
		c.setX(50);
		c.setY(50);
		
	}

	@Override
	public void apply(ViewFacade views) {
		views.send(new RemoveFromPileRemote("p1", c));
		views.send(new UpdateRemote(c));
	}

}
