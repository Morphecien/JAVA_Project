package elementsMotionless;

import elementsAll.*;
/**
 * 
 * @author Asus
 *
 */
public class Chalice extends MotionlessElement implements Itreasures{
	public Chalice() {
		super(new Sprite("4", "purse.png"), Permeability.PENETRABLE, "Chalice");
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
		return 500;
	}
}
