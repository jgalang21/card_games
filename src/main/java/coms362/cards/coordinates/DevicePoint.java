package coms362.cards.coordinates;

import model.Location;

/**
 * 
 * A point in browser device coordinates. 
 * origin at top-left (relative to the viewPort)
 * x increases to the right, 
 * y increases downward. Implies no knowledge of 
 * table orientation. Has the same value in all views.  
 * 
 * cannot be rotated or otherwise manipulated. 
 * 
 * @author Robert Ward
 *
 */
public class DevicePoint  {
	public int x; 
	public int y;
	
	public DevicePoint(int dpx, int dpy) {
		x = dpx;
		y = dpy;
	}
	
	public DevicePoint(Location loc){
		x=loc.getX();
		y=loc.getY();
	}

	public DevicePoint(TablePoint tPos) {
		this((new Point(tPos)).getDeviceLoc());
	}

	public DevicePoint(DevicePoint dPos) {
		this(dPos.x, dPos.y);
	}

}
