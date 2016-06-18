package elementsMotionless;

import elementsAll.* ;

public class Nothing extends MotionlessElement {
	public Nothing() {
		super(new Sprite(" ", "nothing.png"), Permeability.PENETRABLE, "Nothing");
	}
}
