package events.remote;

import coms362.cards.streams.Marshalls;
import events.remote.view.xform.DisplayAttrs;
import events.remote.view.xform.RemoteEvent;
import model.Card;

public class AddToPileRemote extends RemoteEventBase
implements RemoteEvent, Marshalls {
	
	private String pileName;
	private Card c;

	public AddToPileRemote(String pileName, Card c) {
		this.pileName = pileName;
		this.c = c;
	}

	@Override
	public String marshall(DisplayAttrs attrs) {
		return "\n";
	}

	@Override
	public String stringify() {
		return String.format("AddToPileRemote p=%s, c=%d", pileName, c.getId());
	}

}
