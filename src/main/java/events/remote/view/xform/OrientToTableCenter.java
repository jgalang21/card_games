package events.remote.view.xform;

import coms362.cards.abstractcomp.Table;
import coms362.cards.abstractcomp.View;
import coms362.cards.streams.Marshalls;
import model.Location;

public class OrientToTableCenter extends AbstractREWrapper {

	RemoteEvent child = null; 

	public OrientToTableCenter(RemoteEvent child) {
		super(child);
		this.child = child;
	}

	@Override
	public DisplayAttrs personalize(View view){
		int offset = Table.kWidth/2;
		DisplayAttrs attrs = child.personalize(view);
		System.out.println("OrientToTableCenter.personalize, attrs="+attrs.toString());
		int cam = view.getCameraPosition();
		
		Location cLoc = new Location( attrs.pos.getX(), -attrs.pos.getY());
		
		cLoc = cLoc.translate(-offset, offset);
		
		System.out.println("OrientToTableCenter.normalized = "+cLoc.getX()+":"+cLoc.getY());
		
		double invTan = Math.atan((new Double(cLoc.getY()))/(new Double(cLoc.getX())));
		System.out.println("OrientToTableCenter.invTan = "+invTan);
		double angle = -180.0 * (invTan / Math.PI)+90;
		System.out.println("OrientToTableCenter.angle = "+angle);		
		attrs.rot = (int) Math.round(angle);
		System.out.println("OrientToTableCenter.rot = "+attrs.rot);
		return attrs;
	}		
	
	@Override
	public String stringify() {
		// TODO Auto-generated method stub
		return null;
	}

}
