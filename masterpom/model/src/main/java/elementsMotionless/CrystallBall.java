package elementsMotionless;

import elementsAll.*;

/**
 * The class CrystallBall
 * 
 * @author Samuel DUCANGE
 *
 */
public class CrystallBall extends MotionlessElement {
	/**
	 * The constructor of CrystallBall
	 */
	public CrystallBall() {
		super(new Sprite("Q", "crystal_ball.png"), Permeability.PENETRABLE, "Crystal-Ball");
	}
	
	/**
	 * Get the Action on heroes
	 * @return UNLOCKS_GATE
	 */
	@Override
	public ElementsActionsOnHeroes getElementActionOnHeroes() {
		return ElementsActionsOnHeroes.UNLOCKS_GATE;
	}
}
