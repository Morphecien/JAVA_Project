package elementsMobile;

import java.util.ArrayList;

import contract.Movement;
import elementsAll.Permeability;
import elementsAll.Sprite;

public class MagicBall extends MobileAuto{
	private final ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	private final String spriteSymbol = "X" ;
	private int spriteNumber ;
	final private Sprite GreenSprite = new Sprite(this.getSpriteSymbol(), "fireball_1.png") ;
	final private Sprite CyanSprite = new Sprite(this.getSpriteSymbol(), "fireball_2.png") ;
	final private Sprite PurpleSprite = new Sprite(this.getSpriteSymbol(), "fireball_3.png") ;
	final private Sprite RedSprite = new Sprite(this.getSpriteSymbol(), "fireball_4.png") ;
	final private Sprite YellowSprite = new Sprite(this.getSpriteSymbol(), "fireball_5.png") ;

	/**
	 * @return the greenSprite
	 */
	public Sprite getGreenSprite() {
		return GreenSprite;
	}

	/**
	 * @return the cyanSprite
	 */
	public Sprite getCyanSprite() {
		return CyanSprite;
	}

	/**
	 * @return the purpleSprite
	 */
	public Sprite getPurpleSprite() {
		return PurpleSprite;
	}

	/**
	 * @return the redSprite
	 */
	public Sprite getRedSprite() {
		return RedSprite;
	}

	/**
	 * @return the yellowSprite
	 */
	public Sprite getYellowSprite() {
		return YellowSprite;
	}

	public MagicBall() {
		super(new Sprite("X", "fireball_5.png"), Permeability.PENETRABLE, "Magicball");
		prepareSprites() ;
		this.initialize() ;
		this.initIA();
	}
	
	private void prepareSprites(){
		this.getSprites().add(this.getGreenSprite()) ;
		this.getSprites().add(this.getCyanSprite()) ;
		this.getSprites().add(this.getPurpleSprite()) ;
		this.getSprites().add(this.getRedSprite()) ;
		this.getSprites().add(this.getYellowSprite()) ;
	}
	
	private void changeSprite(){
		int newSprite = this.getSpriteNumber()+1 ;
		int size = this.getSprites().size() ;
		if (newSprite < size){
			this.setSpriteNumber(this.getSpriteNumber()+1) ;
		}
		else{
			this.setSpriteNumber(0) ;
		}
		this.setSprite(this.getSprites().get(getSpriteNumber()));
	}
	
	public ArrayList<Sprite> getSprites() {
		return sprites;
	}
	
	public String getSpriteSymbol() {
		return spriteSymbol;
	}
	
	public int getSpriteNumber() {
		return spriteNumber;
	}

	public void setSpriteNumber(int spriteNumber) {
		this.spriteNumber = spriteNumber;
	}

/*	@Override
	public void movement(){
		super.movement() ;
	}*/
	public void initIA(){
		this.setIA_behavior(new IA_Bounce(this));
	}
	
	public void choosePlayerDirection(){
		this.setIA_behavior(new IA_ChoosePlayerDirection(this));
		this.autoMovement();
		this.setIA_behavior(new IA_Bounce(this)) ;
	}

	@Override
	public synchronized void autoMovement() {
		this.getIA_behavior().autoMovement();
		this.changeSprite();
	}
	
	@Override
	public void activate(Movement direction){
		this.inverseDirection(direction);
		super.activate(direction);
	}
	
	@Override
	protected void initialize(){
		super.initialize() ;
		this.setSpriteNumber(this.getSprites().size());
	}
	
	@Override
	public void reinitialize(){
		if (this.isActive()){
			this.deleteObject();
		}
		this.initialize();
	}

	@Override
	protected void isMobileAction(int xDirection, int yDirection) {	// Monsters die
		if (this.isEndMove() == false){
			final int size = this.getWorld().getMobiles().size() ;
			int indexKill = -1 ;
			int indexPickUpPlayer = -1 ;
			for (int k = 0 ; k < size ; k++){
				MobileElement mobile = this.getWorld().getMobiles().get(k) ;
				if ((mobile.getX() == (this.getX() + xDirection)) && (mobile.getY() == (this.getY() + yDirection))){
					if (mobile.getFileSymbol() != "Player"){		// Kill Monster
						indexKill = k ;
					}
					else{
						indexPickUpPlayer = k;						// Pick up by Lorann
					}
				}
			}
			if (indexKill !=-1){
				MobileElement mobile = this.getWorld().getMobiles().get(indexKill) ;					// Kill Monster
				System.out.println("A mobile was died (Magic-ball event) : " + mobile.getFileSymbol());
				this.deleteObject(mobile);
				this.reinitialize() ;
			}
			else if (indexPickUpPlayer != -1){
				MobileElement mobile = this.getWorld().getMobiles().get(indexPickUpPlayer) ;			// Pick up by Lorann
				System.out.println("The Magic-ball was pick-up by Lorann (Magic-ball event) : " + mobile.getFileSymbol());
				this.reinitialize() ;
			}
		}
	}
}
