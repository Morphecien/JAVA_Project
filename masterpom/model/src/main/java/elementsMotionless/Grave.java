package elementsMotionless;

import elementsAll.*;

public class Grave extends MotionlessElement{
	public Grave() {
		super(new Sprite("+", "grave.png"), Permeability.BLOCKING, "Grave");
	}
	
	@Override
	public ElementsActionsOnHeroes getElementActionOnHeroes() {
		return ElementsActionsOnHeroes.DIE;
	}

}