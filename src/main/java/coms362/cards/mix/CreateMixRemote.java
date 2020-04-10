package coms362.cards.mix;

import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.View;
import coms362.cards.streams.Marshalls;
import coms362.events.remote.view.attributes.CardShow;
import coms362.events.remote.view.attributes.ElVisibility;
import events.remote.RemoteEventBase;
import events.remote.view.xform.DisplayAttrs;
import events.remote.view.xform.RemoteEvent;
import model.Card;
import model.Location;

public class CreateMixRemote extends RemoteEventBase
implements RemoteEvent, Marshalls {

	DisplayAttrs params;
	Card c; 
	
	public CreateMixRemote(Player owner, Card card) {
		c = card;
		params = new DisplayAttrs(owner, null,
			0, 
			ElVisibility.visible,
			(card.isFaceUp())? CardShow.up : CardShow.down,
			new Location(card.getX(), card.getY()),
			card.getRotate()
		);
	}

	@Override
	public DisplayAttrs personalize(View view){
		return params;
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
		return "CreateMixRemote Card id=" + c.getId() + ", "+params.owner.toString();
	}
}
