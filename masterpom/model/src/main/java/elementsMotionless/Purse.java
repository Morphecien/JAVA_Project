package elementsMotionless;

import elementsAll.*;

/**
 * The class Purse
 * 
 * @author Samuel DUCANGE
 *
 */
public class Purse extends MotionlessElement implements Itreasures{
	/**
	 * The constructor of Purse
	 */
	public Purse() {
		super(new Sprite("1", "purse.png"), Permeability.PENETRABLE, "Purse");
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
	 * @return 530
	 */
	public int collectTreasure() {
		return 530;
	}
}
