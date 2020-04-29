package coms362.cards.WAR;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.app.ViewFacade;
import events.remote.SetBottomPlayerTextRemote;
import model.Card;
import model.Pile;

public class SweepCmd implements Move {
	
	private Card c1;

	private Player p;
	private String yeet;
	
	public SweepCmd(Card c1,Player p) {
		this.c1 = c1;
	
		this.p = p;
	}

	@Override
	public void apply(Table table) {
		WarTable x = (WarTable) table;
		
		if(x.hasFirstShow() && x.hasSecondShow()) {
			x.awardPot();
		}
		
		
	}

	@Override
	public void apply(ViewFacade views) {
	
		views.send(new SetBottomPlayerTextRemote(yeet, p));
	}

}
