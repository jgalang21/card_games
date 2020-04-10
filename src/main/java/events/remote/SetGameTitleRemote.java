package events.remote;

import coms362.cards.streams.Marshalls;
import events.remote.view.xform.DisplayAttrs;
import events.remote.view.xform.RemoteEvent;

public class SetGameTitleRemote extends RemoteEventBase
implements RemoteEvent, Marshalls {
	
	private String title = "";
	
	public SetGameTitleRemote(String newTitle){
		title = newTitle;
	}

	@Override
	public String marshall(DisplayAttrs attrs) {
		return String.format("$('#game-title').text('%s');", title);
	}

	@Override
	public String stringify() {
		return "SetGameTitle = "+title;
	}
}
