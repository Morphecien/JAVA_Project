package elementsMotionless;

public abstract class MotionlessDetermineElement {

	public static final MotionlessElement	VBONE			= new VBone() ;
	public static final MotionlessElement	HBONE			= new HBone() ;
	public static final MotionlessElement	BONE			= new Bone() ;
	public static final MotionlessElement	GATECLOSE		= new GateClosed() ;
	public static final MotionlessElement	GATEOPEN		= new GateOpen() ;
	public static final MotionlessElement	CRYSTALBALL		= new CrystallBall() ;
	public static final MotionlessElement	BLOC			= new Bloc() ;
	public static final MotionlessElement	GRAVE			= new Grave() ;
	public static final MotionlessElement	PURSE			= new Purse() ;
	public static final MotionlessElement	FLACON			= new Flacon() ;
	public static final MotionlessElement	CANDLESTICK		= new Candlestick() ;
	public static final MotionlessElement	CHALICE			= new Chalice() ;
	public static final MotionlessElement	IDOL			= new Idol() ;
	public static final MotionlessElement	NOTHING			= new Nothing() ;
		
	private static MotionlessElement motionlessElements[] = {VBONE, HBONE, BONE, GATECLOSE, GATEOPEN, CRYSTALBALL, BLOC, GRAVE, PURSE, FLACON, CANDLESTICK, CHALICE, IDOL};

	
	public static MotionlessElement getFromFileSymbol(final String fileSymbol) {
		for (MotionlessElement motionlessElement  : motionlessElements) {
			if (motionlessElement.getFileSymbol().equals(fileSymbol)) {
				return motionlessElement;
			}
		}
		return NOTHING;
	}
}
