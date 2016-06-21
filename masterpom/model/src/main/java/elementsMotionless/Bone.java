package elementsMotionless;

import elementsAll.*;

/**
 * The class Bone
 * 
 * @author Samuel DUCANGE
 *
 */
public class Bone extends MotionlessElement {
	/**
	 * Constructor of Bone
	 */
	public Bone() {
		super(new Sprite("O", "bone.png"), Permeability.BLOCKING, "Bone");
	}
}
