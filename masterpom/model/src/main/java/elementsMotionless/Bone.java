package elementsMotionless;

import elementsAll.*;

public class Bone extends MotionlessElement {
	public Bone() {
		super(new Sprite(" Bone ", "bone.png"), Permeability.BLOCKING, 'O');
	}
}
