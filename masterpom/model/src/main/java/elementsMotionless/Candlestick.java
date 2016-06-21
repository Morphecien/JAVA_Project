package elementsMotionless;

import elementsAll.*;

/**
 * The class Candlestick
 * 
 * @author Samuel DUCANGE
 *
 */
public class Candlestick extends MotionlessElement implements Itreasures{
	/**
	 * The constructor of Candlestick
	 */
	public Candlestick() {
		super(new Sprite("3", "candlestick.png"), Permeability.PENETRABLE, "Candlestick");
	}
	
	/**
	 * Get the Action on heroes
	 * @return COLLECT
	 */
	@Override
	public ElementsActionsOnHeroes getElementActionOnHeroes() {
		return ElementsActionsOnHeroes.COLLECT;
	}

	/**
	 * Collect the treasure (score)
	 * @return 700
	 */
	public int collectTreasure() {
		return 700;
	}
}
