package elementsMotionless;

public abstract class MotionlessDetermineElement {

	public static final MotionlessElement	VBONE			= new VBone() ;
	public static final MotionlessElement	HBONE			= new HBone() ;
	public static final MotionlessElement	BONE			= new Bone() ;
	public static final MotionlessElement	GATECLOSE		= new GateClosed() ;
	public static final MotionlessElement	GATEOPEN		= new GateOpen() ;
	public static final MotionlessElement	CRYSTALBALL		= new CrystallBall() ;
	public static final MotionlessElement	PURSE			= new Purse() ;
	
	private static MotionlessElement motionlessElements[] = {VBONE, HBONE, BONE, GATECLOSE, GATEOPEN, CRYSTALBALL, PURSE};

	
	public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
		for (MotionlessElement motionlessElement  : motionlessElements) {
			if (motionlessElement.getFileSymbol() == fileSymbol) {
				return motionlessElement;
			}
		}
		return null;
	}
}
