package events.remote;

import coms362.cards.abstractcomp.View;
import events.remote.view.xform.DisplayAttrs;
import events.remote.view.xform.RemoteEvent;

public abstract class RemoteEventBase
implements RemoteEvent
{

    @Override
    public String marshall(View view) {
    	return marshall(personalize(view));
    }

	@Override
	public DisplayAttrs personalize(View view) {
		return new DisplayAttrs();
	}
}
