package elementsMotionless;

import elementsAll.*;

public class Candlestick extends MotionlessElement implements Itreasures{
	public Candlestick() {
		super(new Sprite("3", "candlestick.png"), Permeability.PENETRABLE, "Candlestick");
	}
	
	@Override
	public ElementsActionsOnHeroes getElementActionOnHeroes() {
		return ElementsActionsOnHeroes.COLLECT;
	}

	public int collectTreasure() {
		return 700;
	}
}
