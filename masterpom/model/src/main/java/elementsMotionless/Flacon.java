package elementsMotionless;

import elementsAll.*;

public class Flacon extends MotionlessElement implements Itreasures{
	public Flacon() {
		super(new Sprite("2", "flacon.png"), Permeability.PENETRABLE, "Flacon");
	}
	
	@Override
	public ElementsActionsOnHeroes getElementActionOnHeroes() {
		return ElementsActionsOnHeroes.COLLECT;
	}

	public int collectTreasure() {
		return 300;
	}
}
