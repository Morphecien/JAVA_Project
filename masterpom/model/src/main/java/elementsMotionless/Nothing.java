package elementsMotionless;

import elementsAll.* ;
/**
 * 
 * @author Asus
 *
 */
public class Nothing extends MotionlessElement {
	public Nothing() {
		super(new Sprite(" ", "nothing.png"), Permeability.PENETRABLE, Permeability.PENETRABLE,"Nothing");
	}
}
