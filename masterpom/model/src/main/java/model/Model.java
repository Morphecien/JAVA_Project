package model;

import java.awt.Image;
import java.util.Observable;

import contract.IModel;
import elementsAll.Element;
import elementsMobile.MobileElement;
import world.Iworld;
import world.World;
import world.WorldAnswer;

public class Model extends Observable implements IModel {
	private final WorldAnswer worldAnswer ;
	private int level;
//	private Iworld world ;
	private World world ;
	private String message ;
	
	public Model() {
		this.message = "" ;
		startLevel(1) ;
		worldAnswer = new WorldAnswer(world) ;
	}

	public int getLevel() {
		return this.level;
	}
	
	public WorldAnswer getTheWorldAnswer(){
		return this.worldAnswer ;
	}

	private void setLevel(final int level) {
		this.level = level ;
	}
	
/*	private Iworld startLevel(final int level){
		setLevel(level) ;
		this.world = new World(getLevel()) ;
		return this.world ;
	}*/
	private void startLevel(final int level){
		setLevel(level) ;
		this.world = new World(getLevel()) ;
	}
	
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
	
	private Iworld getWorld(){
		return this.world ;
	}
	
	public void setMessage(final String txt){
		this.message = txt ;
	}

	public void loadMessage(final String key) {
	//	final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
		this.setMessage(key);
	}

	public Observable getObservable() {
		return this.world;
	}

	public String getMessage() {
		return this.message;
	}

	public int getWidth() {
		return this.getWorld().getWidth() ;
	}

	public int getHeight() {
		return this.getWorld().getHeight() ;
	}

	public void LorannMoveUP() {
		this.getWorld().getLorann().moveUp();
	}

	public void LorannMoveDOWN() {
		this.getWorld().getLorann().moveDown() ;
	}

	public void LorannMoveLEFT() {
		this.getWorld().getLorann().moveLeft() ;
	}

	public void LorannMoveRIGHT() {
		this.getWorld().getLorann().moveRight() ;
	}

	public void getWorldAnswer() {
	//	this.world.getWorldAnswer();
		this.getTheWorldAnswer().getWorldAnswer();
	}
	
	

}
