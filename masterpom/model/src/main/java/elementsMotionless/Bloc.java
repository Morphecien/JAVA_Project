package elementsMotionless;

import elementsAll.*;
/**
 * 
 * @author Asus
 *
 */
public class Bloc extends MotionlessElement{
	public Bloc() {
		super(new Sprite("#", "Bloc.png"), Permeability.BLOCKING, "Bloc");
	}
	/**
	 * 
	 */
	@Override
	public ElementsActionsOnHeroes getElementActionOnHeroes() {
		return ElementsActionsOnHeroes.PUSH;
	}
}
