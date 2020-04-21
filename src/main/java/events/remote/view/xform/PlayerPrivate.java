package events.remote.view.xform;

import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.View;
import coms362.events.remote.view.attributes.CardShow;

/**
 * 
 * This RemoteEvent wrapper modifies the "show" attribute of its child. When applied
 * to a card, it forces the card to be displayed face down except when the card belongs 
 * to the player associated with the current view. 
 * 
 * Useful to hide the cards in a player's hand when the hand is displayed on an opponents 
 * screen. 
 * 
 * @author Robert Ward
 *
 */
public class PlayerPrivate extends AbstractREWrapper implements RemoteEvent {

	RemoteEvent child = null;
	Player owner;
	
	public PlayerPrivate( Player owner, RemoteEvent child) {
		super(child);
		this.child = child;
		this.owner = owner;
	}
	
	@Override
	public DisplayAttrs personalize(View view) {
		DisplayAttrs attrs = child.personalize(view);
		attrs.owner = owner;
		System.out.println("PlayerPrivate.personalize, attrs="+attrs.toString());		
		if ( owner != null && owner.getPlayerNum() == view.getCameraPosition()){
			attrs.face = CardShow.up;
		}
		else {
			attrs.face = CardShow.down;
		}
		return attrs;
	}

}
