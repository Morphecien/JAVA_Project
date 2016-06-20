package elementsMotionless;

import elementsAll.*;

public class Idol extends MotionlessElement{
	public Idol() {
		super(new Sprite("W", "idol.png"), Permeability.PENETRABLE, "Idol");
	}
	
	@Override
	public ElementsActionsOnHeroes getElementActionOnHeroes() {
		return ElementsActionsOnHeroes.NEWLIFE;
	}

}