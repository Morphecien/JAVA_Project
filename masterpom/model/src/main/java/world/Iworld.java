package world;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Observer;

import elementsAll.Element;
import elementsMobile.Lorann;
import elementsMobile.MobileElement;
import elementsMotionless.MotionlessElement;

public interface Iworld {
	public int getWidth() ;
	public int getHeight() ;
	public Element[][] getElements() ;
	public ArrayList<MobileElement> getMobiles() ;
	public MotionlessElement getElementXY(final int x, final int y) ;
	public Lorann getLorann() ;
	public void setMobileHasChanged() ;
	public void addMobile(MobileElement mobile, int x, int y) ;
	public void addMobile(Lorann lorann, int x, int y) ;
	public void addObserver(Observer o) ;
	public void dropElement(final int x, final int y);
	public void dropElement(final MotionlessElement element, final int x, final int y);
	public void searchGate();
	public void notifyObservers();
}
