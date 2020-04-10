package events.remote.view.xform;

import coms362.cards.abstractcomp.View;
import coms362.cards.streams.Marshalls;

public interface RemoteEvent extends Marshalls {

	/**
	 * Delegates through the decorator stack to 
	 * obtain base attributes and as the call chain
	 * unwinds, adjusts the view attributes to create
	 * a viewer-appropriate transform for 
	 * the input view. 
	 * 
	 * @param view
	 * @return
	 */
	public DisplayAttrs personalize(View view);

	/**
	 * Entry point through which the view requests
	 * javascript appropriate to the calling context. 
	 * This will only be executed when the core event is not
	 * wrapped. When wrapped this call will be intercepted and 
	 * redirected to the DisplayAttrs signature. 
	 * 
	 * @param view
	 * @return 
	 */
	public String marshall(View view);

	/**
	 * A marshaller that expects viewer appropriate, viewport
	 * relative display attributes. In otherwords this 
	 * call is the delegation path used to reach the ultimate marshaller
	 * after the attributes have been transformed appropriately.
	 * 
	 * @param attrs
	 * @return
	 */
	public String marshall(DisplayAttrs attrs);
	
	
	
}
