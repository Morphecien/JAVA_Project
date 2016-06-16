package elementsMotionless;

import elementsAll.*;

public class Purse extends MotionlessElement implements Itreasures{
	public Purse() {
		super(new Sprite("Purse", "purse.png"), Permeability.PENETRABLE, '1');
	}
	
	@Override
	public ElementsActionsOnHeroes getElementActionOnHeroes() {
		return ElementsActionsOnHeroes.COLLECT;
	}

	public int collectTreasure() {
		return 500;
	}
}
