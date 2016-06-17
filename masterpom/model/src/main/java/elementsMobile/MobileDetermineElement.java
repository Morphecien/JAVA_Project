package elementsMobile;

public class MobileDetermineElement {
	public static final MobileElement		LORANN			= new Lorann() ;
	public static final MobileElement		KYRACKJ			= new Kyrackj() ;
	public static final MobileElement		CARGYV			= new Cargyv() ;
	public static final MobileElement		ARRBARR			= new Arrbarr() ;
	public static final MobileElement		MAARCG			= new Maarcg() ;
		
	private static MobileElement mobileElements[] = {LORANN, KYRACKJ, CARGYV, ARRBARR, MAARCG};

		
	public static MobileElement getFromFileSymbol(final String fileSymbol) {
		for (MobileElement mobileElement  : mobileElements) {
			if (mobileElement.getFileSymbol().equals(fileSymbol)) {
				return mobileElement;
			}
		}
		return null;
	}
}
