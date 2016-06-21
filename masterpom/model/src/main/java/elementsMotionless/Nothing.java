package elementsMotionless;

import elementsAll.* ;

/**
 * The class Nothing
 * 
 * @author Samuel DUCANGE
 *
 */
public class Nothing extends MotionlessElement {
	/**
	 * The constructor of Nothing
	 */
	public Nothing() {
		super(new Sprite(" ", "nothing.png"), Permeability.PENETRABLE, Permeability.PENETRABLE,"Nothing");
	}
}
