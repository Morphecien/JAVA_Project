package elementsMotionless;

import elementsAll.*;

public class CrystallBall extends MotionlessElement {
	public CrystallBall() {
		super(new Sprite("Q", "crystal_ball.png"), Permeability.PENETRABLE, "Crystall-ball");
	}
	
	@Override
	public ElementsActionsOnHeroes getElementActionOnHeroes() {
		return ElementsActionsOnHeroes.UNLOCKS_GATE;
	}
}
