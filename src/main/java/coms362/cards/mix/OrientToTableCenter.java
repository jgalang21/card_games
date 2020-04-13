package coms362.cards.mix;

import coms362.cards.abstractcomp.View;
import coms362.cards.streams.Marshalls;
import events.remote.view.xform.AbstractREWrapper;
import events.remote.view.xform.DisplayAttrs;
import events.remote.view.xform.RemoteEvent;
import model.Location;

public class OrientToTableCenter extends AbstractREWrapper {

	private RemoteEvent child = null; 

	public OrientToTableCenter(RemoteEvent child) {
		super(child);
		this.child = child;
	}

	@Override
	public DisplayAttrs personalize(View view){
		DisplayAttrs attrs = child.personalize(view);
		System.out.println("OrientToTable.personalize, attrs="+attrs.toString());
		int cam = view.getCameraPosition();
		int offset = attrs.owner.getPlayerNum() - cam;
		attrs.rot = 90 * offset;
		return attrs;
	}		
	
	@Override
	public String stringify() {
		// TODO Auto-generated method stub
		return null;
	}

}
