package movements;

import java.awt.Point;

import contract.Movement;

public abstract class CoordDeplacement {
	public static final Position UP = 			new Position(new Point(0, -1), Movement.UP) ;
	public static final Position UP_LEFT = 		new Position(new Point(-1, -1), Movement.UP_LEFT) ;
	public static final Position LEFT = 		new Position(new Point(-1, 0), Movement.LEFT) ;
	public static final Position DOWN_LEFT = 	new Position(new Point(-1, 1), Movement.DOWN_LEFT) ;
	public static final Position DOWN = 		new Position(new Point(0, 1), Movement.DOWN) ;
	public static final Position DOWN_RIGHT = 	new Position(new Point(1, 1), Movement.DOWN_RIGHT) ;
	public static final Position RIGHT = 		new Position(new Point(1, 0), Movement.RIGHT) ;
	public static final Position UP_RIGHT = 	new Position(new Point(1, -1), Movement.UP_RIGHT) ;
	public static final Position NOPE =			new Position(new Point(0, 0), Movement.NOPE) ;
	
	private static Position[] move = {UP, UP_LEFT, LEFT, DOWN_LEFT, DOWN, DOWN_RIGHT, RIGHT, UP_RIGHT} ;
	
	public static Position determinePositionMovement(Movement movement){
		for (Position position : move){
			if (position.getDirection() == movement){
				return position ;
			}
		}
		return NOPE;
	}
}
