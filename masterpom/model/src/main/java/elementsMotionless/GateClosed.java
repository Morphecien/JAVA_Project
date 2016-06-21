package elementsMotionless;

import elementsAll.*;

/**
 * The class GateClosed
 * 
 * @author Samuel DUCANGE
 *
 */
public class GateClosed extends MotionlessElement {
	/**
	 * The constructor of GateClosed
	 */
	public GateClosed() {
		super(new Sprite("Y", "gate_closed.png"), Permeability.BLOCKING, "Gate-Close");
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
