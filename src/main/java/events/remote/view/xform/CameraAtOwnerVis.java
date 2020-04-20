package events.remote.view.xform;

import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.View;
import coms362.events.remote.view.attributes.ElVisibility;
import events.remote.SetBottomPlayerTextRemote;

public class CameraAtOwnerVis extends AbstractREWrapper {
 
	RemoteEvent child = null; 

	public CameraAtOwnerVis( RemoteEvent child) {
		super(child);
		this.child = child;
	}

	@Override
	public DisplayAttrs personalize(View view) {
		DisplayAttrs attrs = child.personalize(view);
		System.out.println("CameraA1OwnerVis.personalize, attrs="+attrs.toString());		
		Player owner = attrs.owner;
		if ( owner != null && owner.getPlayerNum() == view.getCameraPosition()){
			attrs.vis = ElVisibility.visible;
		}
		else {
			attrs.vis = ElVisibility.invisible;
		}
		return attrs;
	}
}
