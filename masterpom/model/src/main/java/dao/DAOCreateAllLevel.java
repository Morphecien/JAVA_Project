package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOCreateAllLevel {
	private final Connection connection;
	private final MapProperties mapProperties ;
	
	public DAOCreateAllLevel(Connection connection) throws SQLException {
		this.connection = connection ;
		this.mapProperties = new MapProperties() ;
	}
	
	private Connection getConnection(){
		return this.connection ;
	}

	boolean insertAllLevel(){
		try {
			String sqlSelect = "{CALL selectLevel (?)}" ;
			String sqlInsert = "{CALL insertLevel (?)}" ;
			final CallableStatement callSelect = this.getConnection().prepareCall(sqlSelect);
			final CallableStatement callInsert = this.getConnection().prepareCall(sqlInsert);
			for (int loop = 1 ; loop < (mapProperties.getNberLevel()+1) ; loop++){
				callSelect.setInt(1, loop);
				callSelect.execute();
				final ResultSet resultSet = callSelect.getResultSet();
				if (resultSet.first() == false) {
					callInsert.setInt(1, loop);
					callInsert.execute();
				}
			}
			return true ;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}
}
