package events.remote.view.xform;

import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.View;

/**
 * Like OrientToPlayer, except that this preserves any
 * arbitrary angle between the child managed object and 
 * the edge of the table. 
 * 
 * @author Robert Ward
 *
 */
public class OrientToTable extends AbstractREWrapper {

	RemoteEvent child = null; 
	Player p; 

	public OrientToTable( Player player, RemoteEvent child) {
		super(child);
		this.child = child;
		this.p = player;
	}

	@Override
	public DisplayAttrs personalize(View view) {
		DisplayAttrs attrs = child.personalize(view);
		attrs.rot = attrs.rot + ((p.getPlayerNum() +4 - view.getCameraPosition()) % 4 * 90) ;
		return attrs;
	}
	

}
