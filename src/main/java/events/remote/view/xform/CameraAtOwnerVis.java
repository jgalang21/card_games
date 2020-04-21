package events.remote.view.xform;

import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.View;
import coms362.events.remote.view.attributes.ElVisibility;

/**
 * This decorator will make an element visible only when it
 * belongs to the player who is "in front of" the camera, i.e., 
 * when that player is positioned at the bottom of the 
 * browser presentation. 
 * 
 * @author Robert Ward
 *
 */
public class CameraAtOwnerVis extends AbstractREWrapper {
 
	RemoteEvent child = null;
	Player p = null; 

	public CameraAtOwnerVis( RemoteEvent child) {
		super(child);
		this.child = child;
	}
	
	public CameraAtOwnerVis(Player p, RemoteEvent child){
		super(child);
		this.child = child;
		this.p = p; 
	}

	@Override
	public DisplayAttrs personalize(View view) {
		DisplayAttrs attrs = child.personalize(view);
		System.out.println("CameraA1OwnerVis.personalize, attrs="+attrs.toString());		
		Player owner = (attrs.owner != null) ? attrs.owner : p ;
		if ( owner != null && owner.getPlayerNum() == view.getCameraPosition()){
			attrs.vis = ElVisibility.visible;
		}
		else {
			attrs.vis = ElVisibility.invisible;
		}
		return attrs;
	}
}
