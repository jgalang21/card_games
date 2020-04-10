package events.remote;

import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.View;
import coms362.cards.streams.Marshalls;
import coms362.events.remote.view.attributes.ElVisibility;
import events.remote.view.xform.DisplayAttrs;
import events.remote.view.xform.RemoteEvent;
import model.Location;

public class SetBottomPlayerTextRemote extends RemoteEventBase
implements RemoteEvent,  Marshalls {
	
	public String player="Host";
	public Player owner; 
	
	public SetBottomPlayerTextRemote(String name, Player owner) {
		player = name;
		this.owner = owner;
	}


    @Override
    public String marshall(View view) {
    	return marshall(personalize(view));
    }
      
	@Override
	public DisplayAttrs personalize(View view) {
		return new DisplayAttrs(owner, new Location(0,0));
	}    
	
	@Override
	public String marshall(DisplayAttrs attrs) {

			return (attrs.vis != ElVisibility.visible) ? "" : 
				String.format("$('#current-player').text('%s');\n"
				+ "$('#current-player').append($('<span><span>'));", player)
			;
	}

	@Override
	public String stringify() {
		return "SetBottomPlayerText "+player;
	}
}
