package elementsMotionless;

import elementsAll.*;

public class GateOpen extends MotionlessElement {
	public GateOpen() {
		super(new Sprite("Gate-Open", "gate_open.png"), Permeability.PENETRABLE, 'Z');
	}
	
	@Override
	public ElementsActionsOnHeroes getElementActionOnHeroes() {
		return ElementsActionsOnHeroes.EXIT;
	}
}
