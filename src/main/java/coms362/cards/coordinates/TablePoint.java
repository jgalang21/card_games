package coms362.cards.coordinates;


/**
 * A fixed point on the table (i.e., it appears
 * to move in the view port when view position changes). 
 * The origin is at the center of the table and the x axis 
 * runs horizontally to the right when viewed from Player 1's position.
 * 
 * x values increase to the right, y values increase upward.
 * 
 * @author Robert Ward
 *
 */
public class TablePoint {
	
	public int x; 
	public int y; 

	public TablePoint(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public TablePoint(Point p){
		this(p.x, p.y);
	}
	
	public TablePoint(TablePoint p){
		this(p.x, p.y);
	}
	
	public TablePoint(DevicePoint dPoint){
		this(dPoint.x - ViewPort.kMaxX/2,
				(ViewPort.kMaxY - dPoint.y) - ViewPort.kMaxY/2);
	}
	
	public DevicePoint projectForCamera(int pos){
		Point pVal = new Point(this);
		pVal = pVal.rotateToPos(pos);
		return pVal.getDeviceLoc();
	}
	
	/**
	 * 
	 * repositions this point to a new point on the table.
	 * The new point has the same position relative to a player 
	 * at pos x as this has to a player at pos 1. 
	 * 
	 * @param pos the pos to which the point is copied. 
	 * @return a new TablePoint
	 */
	public TablePoint copyToPos(int pos){
		Point trp = new Point(this);
		trp = trp.rotateToPos(pos);
		return new TablePoint(trp);
	}
}
