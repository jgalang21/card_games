package events.remote;


import coms362.cards.streams.Marshalls;
import events.remote.view.xform.DisplayAttrs;
import events.remote.view.xform.RemoteEvent;

public class SystemStatus extends RemoteEventBase
implements RemoteEvent, Marshalls {
	private String message;

	public SystemStatus(String msg) {
		this.message = msg;
	}

	@Override
	public String marshall(DisplayAttrs attrs) {
		// TODO: post message to browser (status line or popup?)
		return "";
	}

	@Override
	public String stringify() {
		return "SystemStatus "+message;
	}

}
