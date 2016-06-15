package model;

import java.sql.Connection;
import java.sql.SQLException;

public class DAOCreateAllMap {
	private final Connection connection;
	private final MapProperties mapProperties ;
	DAOCreateAMap oneMap ;
	
	public DAOCreateAllMap(Connection connection) throws SQLException {
		this.connection = connection ;
		this.mapProperties = new MapProperties() ;
	}
	
	boolean createAll() throws SQLException{
		boolean allStatement = true ;
		boolean oneStatement = false ;
		for (int loop = 1 ; loop < (mapProperties.getNberLevel()+1) ; loop++){
			oneStatement = createOne(loop) ;
			if (oneStatement == false){
				allStatement = false ;
			}
		}
		if (allStatement == true){
			System.out.println("All levels are imported");
		}
		else{
			System.out.println("There is an error : a (or someone) level(s) failed to import");
		}
		return allStatement;
	}
	
	private boolean createOne(int levelNumber) throws SQLException{
		String accessFile = "" ;
		accessFile = this.mapProperties.getAccess() + accessLevel(levelNumber) + this.mapProperties.getTerminaison() ;
		System.out.print("Level " + levelNumber + " : ");
		this.oneMap = new DAOCreateAMap(connection, accessFile) ;
		if (this.oneMap.getCreationValidation() == true){
			System.out.println("\tImportation Success");
			return true ;
		}
		else{
			System.out.println("\tImportation Failed");
			return false ;
		}
	}
	
	private String accessLevel(int numberLevel){
		if (numberLevel < 10){
			return "00" + numberLevel ;
		}
		else if (numberLevel < 100){
			return "0" + numberLevel ;
		}
		else {
			return "" + numberLevel ;
		}
	}
}
