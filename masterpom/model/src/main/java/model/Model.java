package model;

import java.util.Observable;

import contract.IModel;
import dao.MainDAO;

public class Model extends Observable implements IModel {
	private String message;
	private MainDAO mainDAO;

	public Model() {
		this.message = "";
		this.mainDAO = new MainDAO() ;
	}

	public String getMessage() {
		return this.message;
	}
	
	public MainDAO getMainDAO() {
		return this.mainDAO;
	}

	private void setMessage(final String message) {
		this.message = message;
		this.setChanged();
		this.notifyObservers();
	}

	public void loadMessage(final String key) {
	//	final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
	//	this.setMessage(daoHelloWorld.find(key).getMessage());
		this.setMessage("ceci est un test (:") ;
		mainDAO.loadMap(1) ;
	}

	public Observable getObservable() {
		return this;
	}
}
