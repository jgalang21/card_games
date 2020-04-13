package coms362.cards.mix;

import java.util.Comparator;

import model.Card;

public class ByRank<T> implements Comparator< Card> {

	@Override
	public int compare(Card arg0, Card arg1) {
		return arg0.getNumber()-arg1.getNumber();
	}
	
}
