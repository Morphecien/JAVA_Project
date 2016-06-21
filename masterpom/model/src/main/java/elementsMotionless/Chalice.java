package elementsMotionless;

import elementsAll.*;

/**
 * The class Chalice
 * 
 * @author Samuel DUCANGE
 *
 */
public class Chalice extends MotionlessElement implements Itreasures{
	/**
	 * The constructor of Chalice
	 */
	public Chalice() {
		super(new Sprite("4", "purse.png"), Permeability.PENETRABLE, "Chalice");
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
	 * @return 500
	 */
	public int collectTreasure() {
		return 500;
	}
}
