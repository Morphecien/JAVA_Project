package elementsMotionless;

import elementsAll.*;

public class GateClosed extends MotionlessElement {
	public GateClosed() {
		super(new Sprite("Y", "gate_closed.png"), Permeability.BLOCKING, "Gate-Close");
	}
	
	@Override
	public ElementsActionsOnHeroes getElementActionOnHeroes() {
		return ElementsActionsOnHeroes.DIE;
	}
}
