package events.remote;

import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.View;
import coms362.cards.streams.Marshalls;
import coms362.events.remote.view.attributes.ElVisibility;
import events.remote.view.xform.DisplayAttrs;
import events.remote.view.xform.RemoteEvent;
import model.Location;

public class ShowPlayerScore extends RemoteEventBase
implements RemoteEvent, Marshalls {

	Player owner;
	Location pos = new Location(500,500);
	
	public ShowPlayerScore( Player owner, Location pos){
		this.owner = owner;
		if (pos != null) this.pos = pos;
	}
	
	@Override
	public DisplayAttrs personalize(View view) {
		DisplayAttrs rval = new DisplayAttrs(owner, pos);
		rval.cameraPos=view.getCameraPosition();
		return rval;
	}


	@Override
	public String marshall(DisplayAttrs attrs) {
		System.out.format("ShowPlayerScore.marshall (detail) owner=%s, attrs=%s%n", owner.toString(), attrs.toString());
		return (attrs.vis != ElVisibility.visible) ? "" : 		
			String.format("$('#current-player span')"
				+ ".text('Score: %d')",
				owner.getScore());
	}

	@Override
	public String stringify() {
		return String.format("ShowPlayerScore %d %d", 
				owner.getPlayerNum(), owner.getScore());
	}
}
