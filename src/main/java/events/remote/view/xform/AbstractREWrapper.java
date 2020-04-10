package events.remote.view.xform;

import coms362.cards.abstractcomp.View;
import coms362.cards.streams.Marshalls;

/**
 * 
 * This is the base class for all View Transform wrappers 
 * for Presentation objects (right now, implementers of Marshalls). 
 * 
 * These wrappers extract the display attributes from the base object
 * and then transform them when the view calls the marshaller, so that 
 * the javascript will position, orient, and show the object appropriately
 * for current game state of the object, the position of the camera, the role of the party at that position, 
 * and if relevant, the role of parties at other positions.
 * 
 * The end result is the combination of transforms from some arbitrary number 
 * of wrappers (with different functions), attached to the core display object
 * by the move when it creates them. 
 * 
 * Thus, it is conceivable that the rules could pass in specific wrappers 
 * to the move at move creation time to further extend this capability. 
 * 
 * @author Robert Ward
 *
 */
public class AbstractREWrapper implements RemoteEvent, Marshalls   {
	private RemoteEvent child;
	
	public AbstractREWrapper(RemoteEvent child){
		this.child = child;
	}
	
	@Override
	public String marshall(View view){
		DisplayAttrs attrs = personalize(view);
		return marshall(attrs);
	}

	/* (non-Javadoc)
	 * @see events.remote.xform.DRemoteEvent#personalize(coms362.cards.abstractcomp.View)
	 * 
	 * This is our hook for changing the display attributes before use 
	 * in the delegation to marshall(attrs). 
	 */
	@Override
	public DisplayAttrs personalize(View view) {
		return child.personalize(view);
	}

	@Override
	public String marshall(DisplayAttrs attrs) {
		return child.marshall(attrs);
	}

	@Override
	public String stringify() {
		return child.stringify();
	}
}
