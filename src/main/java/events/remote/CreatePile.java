package events.remote;

import coms362.cards.abstractcomp.View;
import coms362.cards.streams.Marshalls;
import events.remote.view.xform.DisplayAttrs;
import events.remote.view.xform.RemoteEvent;
import model.Location;
import model.Pile;

public class CreatePile extends RemoteEventBase
implements RemoteEvent, Marshalls {
	
	private Pile p;
	
	public CreatePile( Pile p){
		this.p = p; 
	}
	
	@Override
	public DisplayAttrs personalize(View view) {
		return new DisplayAttrs(null, p.getLocation());
	}

	@Override
	public String marshall(DisplayAttrs attrs) {
		Location loc = p.getLocation();
		return String.format(
            "%s = new cards.Deck({faceUp:%b, x:%d, y:%d});",
			p.name,
			p.visible,
			loc.getX(),
			loc.getY()
		);		
	}

	public String stringify() {
		return "CreatePile p="+p.getName();
	}

}
	
	


