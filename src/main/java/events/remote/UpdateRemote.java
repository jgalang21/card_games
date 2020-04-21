package events.remote;

import coms362.cards.abstractcomp.View;
import coms362.cards.streams.Marshalls;
import coms362.events.remote.view.attributes.CardShow;
import coms362.events.remote.view.attributes.ElVisibility;
import events.remote.view.xform.DisplayAttrs;
import events.remote.view.xform.RemoteEvent;
import model.Card;
import model.Location;

public class UpdateRemote extends RemoteEventBase
implements RemoteEvent, Marshalls{
	Card c; 
	
	public UpdateRemote(Card c){
		this.c = c;
	}
	
	@Override
	public DisplayAttrs personalize(View view) {
		DisplayAttrs attrs =  new DisplayAttrs();
		attrs.pos = new Location(c.getX(),c.getY());
		attrs.rot = c.getRotate();
		attrs.face = (c.isFaceUp()) ? CardShow.up : CardShow.down;
		return attrs;
	}	

	@Override
    public String marshall(DisplayAttrs attrs){
		if (attrs.vis == ElVisibility.invisible) {
			return "";
		} else { //NOTE: hide/show and rotate must be in this order. 
	    	String rval = 	String.format("card1 = allCards[%d];\n"
				+ "card1.moveTo(%d, %d, 1, null);\n"
				+ "card1.%s;\n"
				+ "card1.rotate(%d);\n"
				+ "card1.id = %d;\n"
				+ "card1.el.click(cardMouseEvent);\n",
				c.getId(),
				attrs.pos.getX(), attrs.pos.getY(),
				(attrs.face == CardShow.up)? "showCard()" : "hideCard()",
				attrs.rot,
				c.getId(),
				c.getId()
			);
    	System.out.format("UpdateRemote.marshall(attrs) %d%s: %s%n", c.getNumber(), c.getSuit(), rval);
    	return rval;
		}
    }
    
    public String stringify(){
    	return "UpdateRemoteCard id="+c.getId();
    }


}
