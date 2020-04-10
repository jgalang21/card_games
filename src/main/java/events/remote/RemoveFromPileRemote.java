package events.remote;

import coms362.cards.streams.Marshalls;
import events.remote.view.xform.DisplayAttrs;
import events.remote.view.xform.RemoteEvent;
import model.Card;

public class RemoveFromPileRemote extends RemoteEventBase
implements RemoteEvent, Marshalls {

	private Card c;

	public RemoveFromPileRemote(String string, Card c)
	{
		this.c = c;
	}



	@Override
	public String marshall(DisplayAttrs attrs) {
		return String.format(
				"discardPile.addCard(allCards[%d]);\n"
				+ "discardPile.render();\n", 
				c.getId()
			);
	}

	@Override
	public String stringify() {
		return "RemoveFromPileRemote card = "+c.getId();
	}

}

