package events.remote;

import coms362.cards.streams.Marshalls;
import events.remote.view.xform.DisplayAttrs;
import events.remote.view.xform.RemoteEvent;
import model.Card;

public class ShowCardRemote extends RemoteEventBase
implements RemoteEvent, Marshalls {

	private Card c;

	public ShowCardRemote(Card c) {
		this.c = c;
	}

	@Override
	public String marshall(DisplayAttrs attrs) {
		return String.format("allCards[%d].showCard();", c.getId());
	}

	@Override
	public String stringify() {
		return "ShowCardRemote card= " + c.getId();
	}



}
