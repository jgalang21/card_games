package events.remote;

import coms362.cards.streams.Marshalls;
import model.Card;
import events.remote.view.xform.DisplayAttrs;
import events.remote.view.xform.RemoteEvent;


public class CreateRemote extends RemoteEventBase
implements RemoteEvent, Marshalls{
	Card c;

	public CreateRemote(Card c) {
		this.c = c;
	}

	@Override
	public String marshall(DisplayAttrs attrs) {
    	return String.format(
        		"card1 = new cards.Card(\'%s\',\'%d', cards.options.table);\n"
    			+ "allCards[%d] = card1;\n",
    			c.getSuit(), c.getNumber(),
    			c.getId()
    		);
	}
	
	@Override
	public String stringify() {
		return "CreateRemote Card id="+c.getId();
	}
}
