package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {

	/** The message. */
	private String message;
	//private String[][] map ;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.message = "";
	//	this.map = new String[12][20] ;
		
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *          the new message
	 */
/*	private void setMessage(final String message) {
		this.message = message;
		this.setChanged();
		this.notifyObservers();
	}*/

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadMessage(final String key) {
		try {
			int level = 1 ;
	//		final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
	//		this.setMessage(daoHelloWorld.find(key).getMessage());
			final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection());
			daoMap.create();
			Map mappe = daoMap.find(level);
			for (int loop = 0 ; loop<12 ; loop++){
				for (int liip = 0 ; liip<20 ; liip++){
					System.out.print(mappe.getMap()[loop][liip] + "    \t- ");
				}
				System.out.println();
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
}
