package events.remote.view.xform;

import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.View;

public class OrientToPlayer extends AbstractREWrapper {

	RemoteEvent child = null; 
	Player p; 

	public OrientToPlayer( Player player, RemoteEvent child) {
		super(child);
		this.child = child;
		this.p = player;
	}

	@Override
	public DisplayAttrs personalize(View view) {
		DisplayAttrs attrs = child.personalize(view);
		attrs.rot = p.getPlayerNum() * 90;
		return attrs;
	}
	

}
