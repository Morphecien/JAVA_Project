package elementsMotionless;

import elementsAll.*;

public class CrystallBall extends MotionlessElement {
	public CrystallBall() {
		super(new Sprite("Crystall-ball", "crystal_ball.png"), Permeability.PENETRABLE, 'Q');
	}
	
	@Override
	public ElementsActionsOnHeroes getElementActionOnHeroes() {
		return ElementsActionsOnHeroes.UNLOCKS_GATE;
	}
}
