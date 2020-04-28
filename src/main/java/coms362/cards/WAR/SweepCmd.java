package coms362.cards.WAR;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.app.ViewFacade;
import model.Card;
import model.Pile;

public class SweepCmd implements Move {
	
	private Card c;
	private Player p;
	
	public SweepCmd(Card c, Player p) {
		this.c = c;
		this.p = p;
	}

	@Override
	public void apply(Table table) {
		
		
		
	}

	@Override
	public void apply(ViewFacade views) {
		
		
	}

}
