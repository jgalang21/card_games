package events.remote.view.xform;

import coms362.cards.abstractcomp.Table;
import coms362.cards.abstractcomp.View;
import coms362.cards.coordinates.DevicePoint;
import coms362.cards.coordinates.Point;
import coms362.cards.coordinates.TablePoint;
import coms362.cards.streams.Marshalls;
import model.Location;

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
