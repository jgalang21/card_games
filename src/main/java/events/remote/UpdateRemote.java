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
    	return	String.format("card1 = allCards[%d];\n"
			+ "card1.moveTo(%d, %d, 1, null);\n"
			+ "card1.rotate(%d);\n"
			+ "card1.faceUp = %b;\n"
			+ "card1.id = %d;\n"
			+ "card1.el.click(cardMouseEvent);\n",
			c.getId(),
			attrs.pos.getX(), attrs.pos.getY(),
			attrs.rot,
			(attrs.face == CardShow.up),
			c.getId(),
			c.getId()
		);
    }
    
    public String stringify(){
    	return "UpdateRemoteCard id="+c.getId();
    }


}
