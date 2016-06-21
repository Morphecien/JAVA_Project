package elementsMotionless;

import elementsAll.*;

/**
 * The class Idol
 * 
 * @author Samuel DUCANGE
 *
 */
public class Idol extends MotionlessElement{
	/**
	 * The constructor of Idol
	 */
	public Idol() {
		super(new Sprite("W", "idol.png"), Permeability.PENETRABLE, "Idol");
	}
	
	/**
	 * Get the Action on heroes
	 * @return NEWLIFE
	 */
	@Override
	public ElementsActionsOnHeroes getElementActionOnHeroes() {
		return ElementsActionsOnHeroes.NEWLIFE;
	}

}