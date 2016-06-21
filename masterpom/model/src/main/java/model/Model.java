package model;

import java.awt.Image;
import java.util.Observable;

import contract.IModel;
import elementsAll.Element;
import elementsMobile.MobileElement;

/**
 * The class Model
 * 
 * @author Samuel DUCANGE
 *
 */
public class Model extends Observable implements IModel {
	private final WorldAnswer worldAnswer ;
	private int level;
	private World world ;
	private String message ;
	
	/**
	 * The constructor of Model
	 */
	public Model() {
		this.message = "" ;
		startLevel(1) ;
		worldAnswer = new WorldAnswer(world) ;
	}
	/**
	 * The constructor of Model
	 * @param level
	 * 			the level
	 */
	public Model(final int level) {
		this.message = "" ;
		startLevel(level) ;
		worldAnswer = new WorldAnswer(world) ;
	}
	
	/**
	 * Get the level number
	 * @return level
	 */
	public int getLevel() {
		return this.level;
	}
	
	/**
	 * Get the WorldAnswer
	 * @return worldAnswer
	 */
	public WorldAnswer getTheWorldAnswer(){
		return this.worldAnswer ;
	}

	/**
	 * Set the level number
	 * @param level
	 * 			the level number
	 */
	private void setLevel(final int level) {
		this.level = level ;
	}
	
	/**
	 * Start a level
	 * @param level
	 * 			the level number
	 */
	private void startLevel(final int level){
		setLevel(level) ;
		this.world = new World(getLevel()) ;
	}
	
	/**
	 * Get all motionless sprites in the world 
	 * @return Image[][]
	 */
	public Image[][] getWorldSprites(){
		Image[][] sprites = new Image[getHeight()][getWidth()];
		for (int y=0 ; y<getHeight() ; y++){
			for (int x=0 ; x<getWidth() ; x++){
				Element element = this.getWorld().getElementXY(x,y) ;
				if (element != null){
					sprites[y][x] = element.getImage() ;
				}
			}
		}
		return sprites ;
	}
	
	/**
	 * Get all the mobile sprites in the world
	 * @return Image[][]
	 */
	public Image[][] getMobileSprites(){
		Image[][] sprites = new Image[getHeight()][getWidth()];
		int size = this.getWorld().getMobiles().size() ;
		int x = 0 ;
		int y = 0 ;
		for (int i = 0 ; i < size ; i++){
			MobileElement mobile = this.getWorld().getMobiles().get(i) ;
			x = mobile.getX() ;
			y = mobile.getY() ;
			sprites[y][x] = mobile.getImage();
		}
		return sprites ;
	}
	
	/**
	 * Get the world
	 * @return world
	 */
	private Iworld getWorld(){
		return this.world ;
	}
	
	/**
	 * Set the message
	 * @param txt
	 * 			the message
	 */
	public void setMessage(final String txt){
		this.message = txt ;
	}
	
	/**
	 * Get the X position of Lorann (for Controller's test)
	 * @return x
	 */
	public int getXLorannPosition(){
		return (int)this.getWorld().getLorann().getPosition().getX() ;
	}
	/**
	 * Get the Y position of Lorann (for Controller's test)
	 * @return y
	 */
	public int getYLorannPosition(){
		return (int)this.getWorld().getLorann().getPosition().getY() ;
	}

	/**
	 * Load a message
	 * @param key
	 * 			the key
	 */
	public void loadMessage(final String key) {
	//	final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
		this.setMessage(key);
	}

	/**
	 * Get the Observable
	 * @return world (Observable)
	 */
	public Observable getObservable() {
		return this.world;
	}

	/**
	 * Get the message
	 * @return message
	 */
	public String getMessage() {
		return this.message;
	}
/**
 * Get the world's width
 * @return width
 */
	public int getWidth() {
		return this.getWorld().getWidth() ;
	}
	/**
	 * Get the world's height
	 * @return height
	 */
	public int getHeight() {
		return this.getWorld().getHeight() ;
	}

	/**
	 * Execute the Lorann's movement (UP)
	 */
	public void LorannMoveUP() {
		this.getWorld().getLorann().moveUp();
	}
	
	/**
	 * Execute the Lorann's movement (UP_LEFT)
	 */
	public void LorannMoveUP_LEFT() {
		this.getWorld().getLorann().moveUpLeft();;
	}
	
	/**
	 * Execute the Lorann's movement (LEFT)
	 */
	public void LorannMoveLEFT() {
		this.getWorld().getLorann().moveLeft() ;
	}
	
	/**
	 * Execute the Lorann's movement (DOWN_LEFT)
	 */
	public void LorannMoveDOWN_LEFT() {
		this.getWorld().getLorann().moveDownLeft() ;
	}

	/**
	 * Execute the Lorann's movement (DOWN)
	 */
	public void LorannMoveDOWN() {
		this.getWorld().getLorann().moveDown() ;
	}
	
	/**
	 * Execute the Lorann's movement (DOWN_RIGHT)
	 */
	public void LorannMoveDOWN_RIGHT() {
		this.getWorld().getLorann().moveDownRight() ;
	}

	/**
	 * Execute the Lorann's movement (RIGHT)
	 */
	public void LorannMoveRIGHT() {
		this.getWorld().getLorann().moveRight() ;
	}
	
	/**
	 * Execute the Lorann's movement (UP_RIGHT)
	 */
	public void LorannMoveUP_RIGHT() {
		this.getWorld().getLorann().moveUpRight();
	}

	/**
	 * Get the WorldAnswer
	 */
	public void getWorldAnswer() {
		this.getTheWorldAnswer().getWorldAnswer();
	}

	/**
	 * Execute the Lorann's magic-ball (SPACE)
	 */
	public void LorannMagicBall() {
		this.getWorld().getLorann().shootBall();
		
	}
	
	

}
