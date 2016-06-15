package dao;

import java.sql.SQLException;

public class MainDAO{
	DAOMap daoMap;
	public MainDAO() {
		createMaps() ;
	}
	
	private void createMaps(){
		try {
			this.daoMap = new DAOMap(DBConnection.getInstance().getConnection());
			this.daoMap.create();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Map loadMap(int level){
		Map mappe = this.daoMap.find(level);
		viewMapConsole(mappe) ;
		return mappe ;
	}
	
	private void viewMapConsole(Map mappe){
		for (int loop = 0 ; loop<12 ; loop++){
			for (int liip = 0 ; liip<20 ; liip++){
				System.out.print(mappe.getMap()[loop][liip] + "    \t- ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
