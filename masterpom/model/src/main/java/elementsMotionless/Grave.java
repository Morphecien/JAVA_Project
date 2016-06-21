package elementsMotionless;

import elementsAll.*;

/**
 * The class Grave
 * 
 * @author Samuel DUCANGE
 *
 */
public class Grave extends MotionlessElement{
	/**
	 * The constructor of Grave
	 */
	public Grave() {
		super(new Sprite("+", "grave.png"), Permeability.BLOCKING, "Grave");
	}
	
	/**
	 * Get the Action on heroes
	 * @return DIE
	 */
	@Override
	public ElementsActionsOnHeroes getElementActionOnHeroes() {
		return ElementsActionsOnHeroes.DIE;
	}

}