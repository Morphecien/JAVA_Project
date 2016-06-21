package model;

import java.util.ArrayList;
import java.util.Observable;

import dao.MainDAO;
import dao.Map;
import elementsAll.Element;
import elementsMobile.Lorann;
import elementsMobile.MobileDetermineElement;
import elementsMobile.MobileElement;
import elementsMobile.Monster;
import elementsMotionless.MotionlessDetermineElement;
import elementsMotionless.MotionlessElement;

/**
 * The class World
 * 
 * @author Samuel DUCANGE
 *
 */
public class World extends Observable implements Iworld{
	private MotionlessElement[][] elements ;
	private final ArrayList<MobileElement> mobiles ;
	private final int width = 20;
	private final int height = 12;
	private Lorann lorann ;
	private MainDAO mainDAO ;
	private int level ;
	private final static int MAXLEVEL = 101 ;
	
	/**
	 * The constructor of World
	 * @param fileNumber
	 * 			the fileNumber
	 */
	public World(final int fileNumber){
		this.mobiles = new ArrayList<MobileElement>() ;
		this.elements = new MotionlessElement[this.getWidth()][this.getHeight()];
		this.mainDAO = new MainDAO() ;
		this.setLevel(fileNumber);
		this.loadFile() ;
	}
	
	private void re_init_World(){
		for (int y = 0 ; y<this.getHeight() ; y++){
			for (int x = 0 ; x<this.getWidth() ; x++){
				this.elements[x][y] = MotionlessDetermineElement.NOTHING ;
			}
		}
		this.getMobiles().removeAll(this.getMobiles()) ;
		if (this.getLorann() != null){
			this.getLorann().getMagicBall().reinitialize();
		}
	}
	
	/**
	 * Get the level
	 * @return level
	 */
	public int getLevel() {
		return this.level;
	}

	/**
	 * Set the level
	 * @param level
	 * 			the level
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Get the width
	 * @return width
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Get the height
	 * @return height
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * Get all MotionLess Elements
	 * @return elements (Element[][])
	 */
	public Element[][] getElements(){
		return this.elements ;
	}
	
	/**
	 * Get all Mobile Elements
	 * @return mobiles (ArrayList)
	 */
	public ArrayList<MobileElement> getMobiles(){
		return this.mobiles ;
	}
	
	/**
	 * Get the Element in X-Y coord in the world
	 * return element[x][y] (MotionlessElement)
	 */
	public MotionlessElement getElementXY(final int x, final int y){
		if ((x < 0) || (y < 0) || (x >= this.getWidth()) || (y >= this.getHeight())){
			return null ;
		}
		return this.elements[x][y] ;
	}
	
	/**
	 * Get the Hero lorann
	 * @return lorann
	 */
	public Lorann getLorann(){
		return this.lorann ;
	}
	
	/**
	 * Set lorann
	 * @param lorann
	 * 			the hero
	 */
	public void setLorann(final Lorann lorann){
		this.lorann = lorann;
	}
	
	/**
	 * Get the Observable
	 * @return this
	 */
	public Observable getObservable() {
		return this;
	}
	
	/**
	 * Drop an element and replace him with a MotionlessElement : NOTHING
	 * @param x
	 * 			the coord X
	 * @param y
	 * 			the coord Y
	 */
	public void dropElement(final int x, final int y){
		this.addElement(MotionlessDetermineElement.getFromFileSymbol(" "), x, y);
		this.worldHasChanged();
	}
	
	/**
	 * Drop an element and replace him with a new Element
	 * @param element
	 * 			the element
	 * @param x
	 * 			the coord X
	 * @param y
	 * 			the coord Y
	 */
	public void dropElement(final MotionlessElement element, final int x, final int y){
		this.addElement(element, x, y);
		this.worldHasChanged();
	}
	
	/**
	 * Add (or change) an element
	 * @param element
	 * 			the element
	 * @param x
	 * 			the coord X
	 * @param y
	 * 			the coord Y
	 */
	private void addElement(final MotionlessElement element, final int x, final int y){
		this.elements[x][y] = element ;
		this.worldHasChanged();	}
	
	/**
	 * Method which replace all the Bloc by Nothing and the Gate Close by a Gate Open
	 */
	public void searchGate(){
		for (int y = 0 ; y<this.getHeight() ; y++){
			for (int x = 0 ; x<this.getWidth() ; x++){
				Element element = this.getElementXY(x, y);
				if (element == MotionlessDetermineElement.GATECLOSE){
					this.addElement(MotionlessDetermineElement.GATEOPEN, x, y);
				}
				else if (element == MotionlessDetermineElement.BLOC){
					this.addElement(MotionlessDetermineElement.NOTHING, x, y);
				}
			}
		}
		this.worldHasChanged();
	}

	/**
	 * Add a new Mobile (Lorann, Monster, or Magic-ball) in coord x,y
	 * @param mobile
	 * 			the mobile
	 * @param x
	 * 			the coord X
	 * @param y
	 * 			the coord Y
	 */
	public void addMobile(final MobileElement mobile, final int x, final int y) {
		this.getMobiles().add(mobile);
		mobile.setWorld(this, x, y);
		if (mobile.getFileSymbol() == "Player"){
			this.setLorann((Lorann) mobile ) ;
		}
		else if (mobile.getFileSymbol() != "Magicball"){
			((Monster) mobile).initIA();
		}
		mobile.setActive(true);
		this.worldHasChanged();
	}
	
	/*private void afficherMobiles(){
		int size = this.getMobiles().size() ;
		System.out.println("Affichage de l'ArrayList d'éléments mobiles, qui contient " + size + " éléments :");
		for (int i = 0 ; i< size ; i++){
			System.out.println("\tPosition n°" + i + " - " + this.getMobiles().get(i).getFileSymbol());
		}
		System.out.println() ;
	}*/
	
	/**
	 * Drop a mobile in the array list of mobiles
	 * @param indexArrayList
	 * 			the indexArrayList
	 */
	public void delMobile(final int indexArrayList){
		this.getMobiles().get(indexArrayList).setActive(false);
		this.getMobiles().remove(indexArrayList) ;
		this.worldHasChanged();
	}
	
	/**
	 * Create the map according the level
	 */
	private void loadFile(){
		this.re_init_World();
		int z = 0 ;
		Map mappe = mainDAO.loadMap(this.getLevel());
		for (int y = 0 ; y<this.getHeight() ; y++){
			for (int x = 0 ; x<this.getWidth() ; x++){
				this.addElement(MotionlessDetermineElement.getFromFileSymbol(mappe.getMap()[y][x]), x, y);
				
				if (this.getElementXY(x, y) == MotionlessDetermineElement.NOTHING){
					MobileElement mobile = MobileDetermineElement.getFromFileSymbol(mappe.getMap()[y][x]) ;
					if (mobile != null){
						this.addMobile(mobile, x, y);
						z++ ;
						System.out.print(this.mobiles.get(z - 1).getSprite()) ;
					}
					else{
						System.out.print(" ") ;
					}
				}
				else{
					System.out.print(this.getElementXY(x, y).getSprite()) ;
				}
			}
			System.out.println();
		}
		System.out.println();
		this.worldHasChanged() ;
	}
	
	/**
	 * Notify the view
	 */
	public void worldHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Notify Observers
	 */
	public void notifyObservers() {
		super.notifyObservers();
	}
	
	/**
	 * Method execute when Lorann was died and reinitialize the level
	 */
	public void lorannDie(){
		this.getLorann().getMagicBall().reinitialize();
		this.getLorann().setLife(this.getLorann().getLife() -1);
		this.getLorann().setScore(0);
		final int size = this.getMobiles().size() ;
		int indexKillPlayer = -1 ;
		for (int k = 0 ; k < size ; k++){
			MobileElement mobile = this.getMobiles().get(k) ;
			mobile.setActive(false) ;
			if (mobile.getFileSymbol() == "Player"){
				indexKillPlayer = k ;
			}
		}
		this.delMobile(indexKillPlayer);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.loadFile();
	}
	
	/**
	 * End of the current level, start the next level (or the first level if the last level was 101)
	 */
	public void endLevel(){
		if (this.getLevel() < MAXLEVEL){
			this.setLevel(getLevel()+1);
		}
		else{
			this.setLevel(1);
		}
		this.loadFile();
	}
}