package elementsMotionless;

import elementsAll.*;

/**
 * The class HBone
 * 
 * @author Samuel DUCANGE
 *
 */
public class HBone extends MotionlessElement {
	/**
	 * The constructor of HBone
	 */
	public HBone() {
		super(new Sprite("-", "horizontal_bone.png"), Permeability.BLOCKING, "H-Bone");
	}
}
