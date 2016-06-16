package model;

import java.util.Observable;

import contract.IModel;
import world.Iworld;
import world.World;

public class Model extends Observable implements IModel {
	private int level;
	private Iworld world ;

	public Model() {
		startLevel(1) ;
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

	public void loadMessage(final String key) {
	//	final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
	//	this.setMessage(daoHelloWorld.find(key).getMessage());
	}

	public Observable getObservable() {
		return this;
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return "Oili oilà (:";
	}
}
