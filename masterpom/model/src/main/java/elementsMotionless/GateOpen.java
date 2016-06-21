package elementsMotionless;

import elementsAll.*;

/**
 * The class GateOpen
 * 
 * @author Samuel DUCANGE
 *
 */
public class GateOpen extends MotionlessElement {
	/**
	 * The constructor of GateOpen
	 */
	public GateOpen() {
		super(new Sprite("Z", "gate_open.png"), Permeability.PENETRABLE, "Gate-Open");
	}
	
	/**
	 * Get the Action on heroes
	 * @return EXIT
	 */
	@Override
	public ElementsActionsOnHeroes getElementActionOnHeroes() {
		return ElementsActionsOnHeroes.EXIT;
	}
}
