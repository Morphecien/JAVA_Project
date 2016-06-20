package elementsMotionless;

import elementsAll.*;

public class Bone extends MotionlessElement {
	public Bone() {
		super(new Sprite("O", "bone.png"), Permeability.BLOCKING, "Bone");
	}
}
