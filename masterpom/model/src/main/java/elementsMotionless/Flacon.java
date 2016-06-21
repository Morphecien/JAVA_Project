package elementsMotionless;

import elementsAll.*;

/**
 * The class Flacon
 * 
 * @author Samuel DUCANGE
 *
 */
public class Flacon extends MotionlessElement implements Itreasures{
	/**
	 * The constructor of Flacon
	 */
	public Flacon() {
		super(new Sprite("2", "flacon.png"), Permeability.PENETRABLE, "Flacon");
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
	 * @return 300
	 */
	public int collectTreasure() {
		return 300;
	}
}
