package events.remote.view.xform;

import coms362.cards.abstractcomp.Player;
import coms362.events.remote.view.attributes.CardShow;
import coms362.events.remote.view.attributes.ElVisibility;
import coms362.events.remote.view.attributes.Orientation;
import model.Location;

public class DisplayAttrs {
	public Player owner = null;
	public Player current = null;
	public int cameraPos = 0; 
	public ElVisibility vis = ElVisibility.visible;
	public CardShow face = CardShow.up;
	public Location pos = new Location(0,0);
	public int rot = 90;
	
	public DisplayAttrs(
		Player owner, 
		Player current,
		int cameraPos, 
		ElVisibility vis,
		CardShow face,
		Location pos,
		int rot
	){
		this.owner = owner;
		this.current = current;
		this.cameraPos = cameraPos;
		this.vis = vis;
		this.face = face;
		this.pos = pos;
		this.rot = rot;
	}
	
	public DisplayAttrs (DisplayAttrs attrs){
		this(
			attrs.owner,
			attrs.current,
			attrs.cameraPos,
			attrs.vis,
			attrs.face,
			attrs.pos,
			attrs.rot
		);
	}
	
	public DisplayAttrs (Player owner, Location pos){
		this.owner = owner;
		this.pos = pos;
	}
	
	public DisplayAttrs (Player owner, int camera){
		this.owner = owner;
		this.cameraPos = camera;
	}
	
	
	/**
	 * For use by operations that operate on remote 
	 * object using only its global index. 
	 */
	public DisplayAttrs() {
		this(null, null); 
	}
	
	@Override
	public String toString(){
		return String.format("owner=%s, current=%s, camera=%d, vis=%s, face = %s%n",
			(owner==null) ? "null": owner.toString(),
			(current==null) ? "null": current.toString(), 
			cameraPos, vis.name(), face.name()
		);
	}
}
