package world;

import java.util.ArrayList;
import java.util.Observable;

import dao.MainDAO;
import dao.Map;
import elementsAll.Element;
import elementsMobile.Lorann;
import elementsMobile.Mobile;
import elementsMotionless.MotionlessDetermineElement;
import elementsMotionless.MotionlessElement;

public class World extends Observable implements Iworld{
	private MotionlessElement[][] elements ;
	private final ArrayList<Mobile> mobiles ;
	private final int width = 20;
	private final int height = 12;
	private Lorann lorann ;
	private MainDAO mainDAO ;
	
	public World(final int fileNumber){
		this.mobiles = new ArrayList<Mobile>() ;
		this.loadFile(fileNumber) ;
		this.mainDAO = new MainDAO() ;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}
	
	public Element[][] getElements(){
		return this.elements ;
	}
	
	public ArrayList<Mobile> getMobiles(){
		return this.mobiles ;
	}
	
	public MotionlessElement getElementXY(final int x, final int y){
		if ((x < 0) || (y < 0) || (x >= this.getWidth()) || (y >= this.getHeight())){
			return null ;
		}
		return this.elements[x][y] ;
	}
	
	public Lorann getLorann(){
		return this.lorann ;
	}
	
	private void addElement(final MotionlessElement element, final int x, final int y){
		this.elements[y][x] = element ;
		if (element != null){
			element.setWorld(this) ;
		}
		this.setChanged();
	}
	
	public void addMobile(final Mobile mobile, final int x, final int y) {
		this.mobiles.add(mobile);
		mobile.setWorld(this, x, y);
		this.setChanged();
		this.notifyObservers();
	}
	
	private void loadFile(final int fileNumber){
		Map mappe = mainDAO.loadMap(fileNumber);
		for (int loop = 0 ; loop<this.getHeight() ; loop++){
			for (int liip = 0 ; liip<this.getWidth() ; liip++){
				this.addElement(MotionlessDetermineElement.getFromFileSymbol(mappe.getMap()[loop][liip]), liip, loop);
				System.out.print(mappe.getMap()[loop][liip] + "    \t- ");
			}
			System.out.println();
		}
		System.out.println();
		this.setChanged() ;
	}
	
	public void setMobileHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}
	
	public void notifyObservers() {
		super.notifyObservers();
	}
}
