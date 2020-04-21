package events.remote.view.xform;

import coms362.cards.abstractcomp.Table;
import coms362.cards.abstractcomp.View;
import model.Location;

/**
 * A RemoteEvent wrapper that adjusts the position (not orientation) of
 * its child (usually a Card) thus preserving the cards apparant location relative to 
 * the table. As the camera moves (think of different player screens) from player position to player position,
 * a card managed by a RemoteEvent wrapped with this class will appear to rotate with the table. 
 * 
 * You can use this class, but you not as a pattern for how to build such a wrapper. 
 * 
 * @author Robert Ward
 *
 */

// TODO: rewrite using DevicePoint, TablePoint, and abstract Point 

public class TableRelativePos extends AbstractREWrapper {

	private RemoteEvent child = null; 
	
	public TableRelativePos(RemoteEvent child) {
		super(child);
		this.child = child;
	}

	@Override
	public DisplayAttrs personalize(View view){
		DisplayAttrs attrs = child.personalize(view);
		int cam = view.getCameraPosition();
		Location adjPos = rotateForCamera(cam, attrs.pos );
		attrs.pos = adjPos;		
		return attrs;
	}

	@Override
	public String stringify() {
		return "TableRelativePos Wrapping "+super.getClass().getSimpleName(); 
	}
	
	private Location rotateForCamera(int cam, Location pos){
		
		final int max = Table.kWidth; // size of table. 
		Location normPos = pos.translate(-max/2,-max/2);
		Location rotNorm = null; 
		switch (cam){
		case 1: return pos; 
		case 2: 	
			rotNorm = normPos.rotate90();
			break;
		case 3: 
			rotNorm = normPos.rotate180();
			break;
		case 4: 
			rotNorm = normPos.rotate90();
			rotNorm = rotNorm.rotate180();
			break;
		}
		return rotNorm.translate(max/2,max/2);

	}
	
	

}
