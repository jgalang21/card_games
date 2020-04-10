package events.remote;

import coms362.cards.streams.Marshalls;
import events.remote.view.xform.DisplayAttrs;
import events.remote.view.xform.RemoteEvent;

public class HideButtonRemote extends RemoteEventBase
implements RemoteEvent, Marshalls {

	private String remoteId;
	
	public HideButtonRemote(String remoteId){
		this.remoteId = remoteId;
	}
	
	@Override
	public String marshall(DisplayAttrs attrs) {
		return String.format("cards362.getById('%s').hide();\n", remoteId);			 

	}
	
	@Override
	public String stringify() {
		return String.format("HideButtonRemote");
	}

}
