package events.remote;

import coms362.cards.streams.Marshalls;
import events.remote.view.xform.DisplayAttrs;
import events.remote.view.xform.RemoteEvent;
import model.Button;

public class CreateButtonRemote extends RemoteEventBase
implements RemoteEvent,  Marshalls {
    private Button button;

    public CreateButtonRemote(Button button) {
        this.button = button;
    }

	@Override
	public String marshall(DisplayAttrs attrs) {
        return String.format("cards362.createButton('%s', '%s', '%s', %d, %d);\n", button.getRemoteId(),
                button.getEvtName(), button.getLabel(), button.getLocation().getX(),
                button.getLocation().getY());
	}
	    
    @Override
    public String stringify() {
        return "CreateButton " + button.getLabel();
    }
}
