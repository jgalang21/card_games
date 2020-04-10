package events.remote.view.xform;

import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.View;
import coms362.events.remote.view.attributes.ElVisibility;
import model.Location;

public class TableAtViewPos extends AbstractREWrapper {

	RemoteEvent child = null; 

	public TableAtViewPos( RemoteEvent child ) {
		super(child);
		this.child = child;
	}

	@Override
	public DisplayAttrs personalize(View view) {
		DisplayAttrs attrs = child.personalize(view);
		Location pos = attrs.pos;
		
		
		
		return attrs;
	}
	

}
