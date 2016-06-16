package world;

import java.util.ArrayList;
import java.util.Observer;

import elementsAll.Element;
import elementsMobile.Lorann;
import elementsMobile.Mobile;
import elementsMotionless.MotionlessElement;

public interface Iworld {
	public int getWidth() ;
	public int getHeight() ;
	public Element[][] getElements() ;
	public ArrayList<Mobile> getMobiles() ;
	public MotionlessElement getElementXY(final int x, final int y) ;
	public Lorann getLorann() ;
	public void setMobileHasChanged() ;
	public void addMobile(Mobile mobile, int x, int y) ;
	public void addMobile(Lorann lorann, int x, int y) ;
	public void addObserver(Observer o) ;
}
