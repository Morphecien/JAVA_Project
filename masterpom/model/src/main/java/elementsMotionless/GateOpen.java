package elementsMotionless;

import elementsAll.*;

public class GateOpen extends MotionlessElement {
	public GateOpen() {
		super(new Sprite("Z", "gate_open.png"), Permeability.PENETRABLE, "Gate-Open");
	}
	
	@Override
	public ElementsActionsOnHeroes getElementActionOnHeroes() {
		return ElementsActionsOnHeroes.EXIT;
	}
}
