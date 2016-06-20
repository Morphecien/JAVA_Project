package elementsMotionless;

import elementsAll.*;
/**
 * 
 * @author Asus
 *
 */
public class Purse extends MotionlessElement implements Itreasures{
	public Purse() {
		super(new Sprite("1", "purse.png"), Permeability.PENETRABLE, "Purse");
	}
	/**
	 * 
	 */
	@Override
	public ElementsActionsOnHeroes getElementActionOnHeroes() {
		return ElementsActionsOnHeroes.COLLECT;
	}
/**
 * 
 */
	public int collectTreasure() {
		return 530;
	}
}
