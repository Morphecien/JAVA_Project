package elementsMotionless;

import elementsAll.*;

public class GateClosed extends MotionlessElement {
	public GateClosed() {
		super(new Sprite("Gate-Close", "gate_closed.png"), Permeability.BLOCKING, 'Y');
	}
	
	@Override
	public ElementsActionsOnHeroes getElementActionOnHeroes() {
		return ElementsActionsOnHeroes.DIE;
	}
}
