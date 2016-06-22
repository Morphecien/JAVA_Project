package movements;

import java.awt.Point;

import contract.Movement;

public class Position {
	private int xDeplacement ;
	private int yDeplacement ;
	private Movement direction ;
	
	private Point point ;
	
	public Position(final Point point, final Movement direction){
		this.point = point ;
		this.xDeplacement = point.x ;
		this.yDeplacement = point.y ;
		this.direction = direction ;
	}

	/**
	 * @return the xDeplacement
	 */
	public int getxDeplacement() {
		return xDeplacement;
	}

	/**
	 * @return the yDeplacement
	 */
	public int getyDeplacement() {
		return yDeplacement;
	}

	/**
	 * @return the point
	 */
	public Point getPoint() {
		return point;
	}
	
	/**
	 * @return the direction
	 */
	public Movement getDirection() {
		return direction;
	}
}
