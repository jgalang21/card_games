package events.remote.view.xform;

import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.View;
import coms362.events.remote.view.attributes.CardShow;

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
