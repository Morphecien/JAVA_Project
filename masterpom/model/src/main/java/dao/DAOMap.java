package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOMap extends DAOEntity<Map>{
	DAOCreateAllLevel daoAllLevel ;
	DAOCreateAllMap daoAllMap ;
	
	public DAOMap(final Connection connection) throws SQLException {
		super(connection) ;
		this.daoAllLevel = new DAOCreateAllLevel(this.getConnection()) ;
		this.daoAllMap = new DAOCreateAllMap(this.getConnection()) ;
	}
	
	@Override
	public boolean create () {
		try {
			this.daoAllLevel.insertAllLevel() ;
			this.daoAllMap.createAll() ;
			return true ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false ;
	}
	
	@Override
	public boolean delete(final Map entity) {
		// Not implemented
		return true;
	}
	
	@Override
	public boolean update(final Map entity) {
		// Not implemented
		return true;
	}
	
	public Map find(final int id) {
		Map map = new Map();
		for (int loop=0 ; loop<12 ; loop++){
			for (int liip=0 ; liip<20 ; liip++){
				map.getMap()[loop][liip] = caseFind(id, liip+1, loop+1) ;
			}
		}
		return map;
	}
	
	private String caseFind(final int id, final int x, final int y){
		String caseMap = null ;
		try {
			final String sql = "{call MapByID_X_Y(?, ?, ?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.setInt(2, x);
			call.setInt(3, y);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				caseMap = resultSet.getString("sprite");
			}
			return caseMap;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
