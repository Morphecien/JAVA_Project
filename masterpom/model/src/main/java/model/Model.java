package model;

import java.awt.Image;
import java.util.Observable;

import contract.IModel;
import elementsAll.Element;
import world.Iworld;
import world.World;

public class Model extends Observable implements IModel {
	private int level;
	private Iworld world ;

	public Model() {
		this.world = startLevel(1) ;
	}

	public int getLevel() {
		return this.level;
	}

	private void setLevel(final int level) {
		this.level = level ;
	}
	
	private Iworld startLevel(final int level){
		setLevel(level) ;
		this.world = new World(getLevel()) ;
		return this.world ;
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
	
	private Iworld getWorld(){
		return this.world ;
	}

	public void loadMessage(final String key) {
	//	final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
	//	this.setMessage(daoHelloWorld.find(key).getMessage());
	}

	public Observable getObservable() {
		return this;
	}

	public String getMessage() {
		return "Oili oilà (:";
	}

	public int getWidth() {
		return this.getWorld().getWidth() ;
	}

	public int getHeight() {
		return this.getWorld().getHeight() ;
	}
}
