package world;

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
	public void worldHasChanged() ;
	public void addMobile(MobileElement mobile, int x, int y) ;
	public void delMobile(final int indexArrayList);
	public void addObserver(Observer o) ;
	public void dropElement(final int x, final int y);
	public void dropElement(final MotionlessElement element, final int x, final int y);
	public void searchGate();
	public void notifyObservers();
}
