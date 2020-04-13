package coms362.cards.mix;

import java.util.Comparator;

import coms362.cards.abstractcomp.Player;

public class OnPlayerNum<T> implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {
		return o1.getPlayerNum() - o2.getPlayerNum();
	}
 
}
