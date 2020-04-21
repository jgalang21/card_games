package events.remote.view.xform;

import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.View;

/**
 * This wrapper modifies the orientation (rotation angle) of its child so that 
 * the child object's center-line is always perpendicular 
 * to the side of the table belonging to player. 
 * This wrapper can be used, for example to make the cards in a hand 
 * 
 * @author Robert Ward
 *
 */
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
		attrs.rot = (p.getPlayerNum() +4  - view.getCameraPosition()) % 4 * 90 ;
		System.err.format("OrientToPlayer rot=%d, player=%d, view=%d%n",
			attrs.rot,	p.getPlayerNum(), view.getCameraPosition());
		return attrs;
	}
	

}
