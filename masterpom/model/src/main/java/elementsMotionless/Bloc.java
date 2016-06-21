package elementsMotionless;

import elementsAll.*;

/**
 * The class Bloc
 * 
 * @author Samuel DUCANGE
 *
 */
public class Bloc extends MotionlessElement{
	/**
	 * Constructor of Bloc
	 */
	public Bloc() {
		super(new Sprite("#", "Bloc.png"), Permeability.BLOCKING, "Bloc");
	}
	
	/**
	 * Get the Action on heroes
	 * @return PUSH
	 */
	@Override
	public ElementsActionsOnHeroes getElementActionOnHeroes() {
		return ElementsActionsOnHeroes.PUSH;
	}
}
