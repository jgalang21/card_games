package coms362.cards.coordinates;

/**
 * A "normal" point in abstract space. 
 * origin at 0,0, x increases upward
 * y increases to the right. 
 * 
 * @author Robert Ward
 *
 */
public class Point {
	public int x;
	public int y;
	
	public Point( int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Point( DevicePoint dp ){
		x = dp.x;
		y = dp.y - ViewPort.kMaxY;
		//translate origin
		x -= ViewPort.kMaxX/2;
		y -= ViewPort.kMaxY/2;
	}
	
	public Point(TablePoint tp){
		this(tp.x, tp.y);
	}
	
	public Point translate(int dx, int dy){
		Point rval = new Point(x+dx, y+dy);
		return rval;
	}
	
	/**
	 * @return a new point rotated 90 deg. 
	 * counterclockwise around the origin. 
	 */
	public Point rotate90cc(){
		int rx = -y; 
		int ry = x;
		return new Point(rx, ry);		
	}
	
	/**
	 * @return a new point rotated 90 deg. 
	 * <em>clockwise</em> around the origin. 
	 */	
	public Point rotate90(){
		int rx = y; 
		int ry = -x;
		return new Point(rx, ry);		
	}
	
	/**
	 * 
	 * Assumes this abstract point is 
	 * in the desired position relative to 
	 * player 1. rotates to the desired player/view
	 * position. 
	 * 
	 * @param pos
	 * @return
	 */
	public Point rotateToPos(int pos){
		Point rval = new Point(x, y);

		for (int i = 1; i < pos; i++){
			rval = rval.rotate90();
		}
		return rval;
	}
	
	/**
	 * maps the point in abstract space to 
	 * a corresponding point in the device space. 
	 * performs no rotation or re-orientation. 
	 * 
	 * @return
	 */
	public DevicePoint getDeviceLoc(){
		int dpx = x + ViewPort.kMaxX/2;
		int dpy = ViewPort.kMaxY - ( y + ViewPort.kMaxY/2) ;
		return new DevicePoint (dpx, dpy);
	}
	
	@Override
	public String toString(){
		return String.format(
			"Point %d, x=%d y=%d%n", hashCode(), x, y
		);
	}
	
	
}
