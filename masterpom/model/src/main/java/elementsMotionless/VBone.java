package elementsMotionless;

import elementsAll.*;

/**
 * The class VBone
 * 
 * @author Samuel DUCANGE
 *
 */
public class VBone extends MotionlessElement {
	/**
	 * The constructor of VBone
	 */
	public VBone() {
		super(new Sprite("I", "vertical_bone.png"), Permeability.BLOCKING, "V-Bone");
	}
}
