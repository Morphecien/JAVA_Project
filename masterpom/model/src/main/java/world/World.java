package world;

import java.util.ArrayList;
import java.util.Observable;

import dao.MainDAO;
import dao.Map;
import elementsAll.Element;
import elementsMobile.Lorann;
import elementsMobile.MobileDetermineElement;
import elementsMobile.MobileElement;
import elementsMotionless.IElementsActionOnHeroes;
import elementsMotionless.Itreasures;
import elementsMotionless.MotionlessDetermineElement;
import elementsMotionless.MotionlessElement;

public class World extends Observable implements Iworld{
	private MotionlessElement[][] elements ;
	private final ArrayList<MobileElement> mobiles ;
	private final int width = 20;
	private final int height = 12;
	private Lorann lorann ;
	private MainDAO mainDAO ;
	
	public World(final int fileNumber){
		this.mobiles = new ArrayList<MobileElement>() ;
		this.mainDAO = new MainDAO() ;
		this.elements = new MotionlessElement[this.getWidth()][this.getHeight()];
		this.loadFile(fileNumber) ;
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
	
	public ArrayList<MobileElement> getMobiles(){
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
	
	public void setHero(final Lorann lorann){
		this.lorann = lorann;
		this.setChanged();
	}
	public Observable getObservable() {
		return this;
	}
	
	public void dropElement(final int x, final int y){
		this.addElement(MotionlessDetermineElement.getFromFileSymbol(" "), x, y);
		this.setChanged();
	}
	
	public void dropElement(final MotionlessElement element, final int x, final int y){
		this.addElement(element, x, y);
		this.setChanged();
	}
	
	private void addElement(final MotionlessElement element, final int x, final int y){
		this.elements[x][y] = element ;
		if (element != null){
			element.setWorld(this) ;
		}
		this.setChanged();
	}
	
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
		this.setChanged();
	//	this.notifyObservers();
	}

	public void addMobile(final MobileElement mobile, final int x, final int y) {
		this.mobiles.add(mobile);
		mobile.setWorld(this, x, y);
		if (mobile.getFileSymbol() == "Player"){
			this.lorann = (Lorann) mobile ;
		}
		this.setChanged();
	//	this.notifyObservers();
	}
	
	public void addMobile(Lorann lorann, int x, int y) {
		this.lorann = lorann ;
		this.addMobile((MobileElement) lorann, x, y);
	}
	
	private void loadFile(final int fileNumber){
		int z = 0 ;
		Map mappe = mainDAO.loadMap(fileNumber);
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
	//	System.out.println();
		this.setChanged() ;
	}
	
	public void worldHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}
	
	public void notifyObservers() {
		System.out.println("Coucou, je notifie ;)");
		super.notifyObservers();
	}
	
	public void getWorldAnswer(){
		final IElementsActionOnHeroes element = this.getElementXY(this.getLorann().getX(), this.getLorann().getY());

		switch (element.getElementActionOnHeroes()) {
			case COLLECT:
				System.out.println("COLLECT !!!! (:");
				this.resolveCollectTreasure((Itreasures) element);
				break;
			case NEWLIFE:
				System.out.println("NEW LIFE !!!! (:");
				this.resolveObtainNewLife();
				break;
			case DIE:
				System.out.println("DIE !!!! ):");
				this.resolveLorannDie();
				break;
			case UNLOCKS_GATE:
				System.out.println("GATE --> OPEN !!!! (:");
				this.resolveUnlocksGate();
				break;
			case NOPE:
			default:
				break;
		}
		worldHasChanged() ;
	}
	private void resolveCollectTreasure(Itreasures element){
	//	System.out.print("score : " + this.getWorld().getLorann().getScore() + " | new ");
		final int score = this.getLorann().getScore() + element.collectTreasure() ;
		this.getLorann().setScore(score) ;
		System.out.println("score : " + this.getLorann().getScore());
		this.dropElement(this.getLorann().getX(), this.getLorann().getY());
	}
	
	private void resolveObtainNewLife(){
		System.out.print("Lifes : " + this.getLorann().getLife() + " | new ");
		final int life = this.getLorann().getLife() + 1 ;
		this.getLorann().setLife(life) ;
		System.out.println("Lifes : " + this.getLorann().getLife());
		this.dropElement(this.getLorann().getX(), this.getLorann().getY());
	}
	
	private void resolveLorannDie(){
		
	}
	
	private void resolveUnlocksGate(){
		this.dropElement(this.getLorann().getX(), this.getLorann().getY());
		searchGate() ;
	//	afficherWorld() ;
		System.out.println(this.getElementXY(2, 3).getSprite().getImage());
		this.worldHasChanged();
	}
		
	private void afficherWorld(){
		for (int y=0 ; y<12 ; y++){
			for (int x=0 ; x<20 ; x++){
				System.out.print(this.getElementXY(x, y).getSprite()) ;
			}
			System.out.println() ;
		}
		System.out.println(this.getElementXY(2, 3).getSprite().getTest());
	}
}
