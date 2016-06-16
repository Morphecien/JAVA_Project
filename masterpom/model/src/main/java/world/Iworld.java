package world;

import java.util.ArrayList;

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
}
