package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

class DAOCreateAMap{
	private final Connection connection;
	private boolean creationValidation ;
	
	public DAOCreateAMap(final Connection connection, final String level) throws SQLException {
		this.connection = connection ;
		
		this.creationValidation = createMap(level) ;
	}
	
	/**
	 * 
	 * @return
	 */
	boolean getCreationValidation() {
		return this.creationValidation;
	}
	
	private Connection getConnection(){
		return this.connection ;
	}
	/**
	 * 
	 * @author Samuel DUCANGE
	 *
	 */
	private static abstract class QueryDAOInsert {
		public static String getQueryInsertCaseMap(){
			return "{CALL insertMap(?, ?, ?, ?)}" ;
		}
		public static String getQuerySelectIDLevel(){
			return "{CALL ID_level_3numbers(?)}" ;
		}
		public static String getQuerySelectMapExist(){
			return "{CALL selectMapExist(?)}" ;
		}
		public static String getQuerySelectIDSprite(){
			return "{CALL select_ID_Sprite(?)}" ;
		}
	}
	
	private void insertCase(int level, int posX, int posY, char spriteRecup){
			String element = determineSprite(spriteRecup) ;
			if (element != "none"){
				int ID_Sprite = recupIntQueryWithOneParameter(QueryDAOInsert.getQuerySelectIDSprite(), element) ;
				this.insertCaseMap(QueryDAOInsert.getQueryInsertCaseMap(), level, posX, posY, ID_Sprite);
			}
	}
		
		private int determineLevel(String file){
//			System.out.println(file);
			int ID_Level = (int) recupIntQueryWithOneParameter(QueryDAOInsert.getQuerySelectIDLevel(), file) ;
//			System.out.println(ID_Level);
			return ID_Level ;
		}
		
		/**
		 * 
		 * @param file
		 * @return
		 */
		private boolean createMap(String file){
			InputStream fr = null ;
			boolean mapExist = false ;
			try {
				fr = this.getClass().getResourceAsStream(file) ;
				int level = determineLevel(file) ;
				
				mapExist = searchMap(level) ;
				if (mapExist == false){
					System.out.print("Missing... ");
					
					generateMap(fr, level) ;
					mapExist = searchMap(level) ;
				}
				else{
					System.out.print("OK ");
				}
				return mapExist ;
			}
			finally{
				if (fr != null) {
					try {
						fr.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		private boolean searchMap(int level){
			try {
				final CallableStatement call = this.getConnection().prepareCall(QueryDAOInsert.getQuerySelectMapExist());
				call.setInt(1, level);
				call.execute();
				final ResultSet resultSet = call.getResultSet();
				if (resultSet.first()) {
					return true ;
				}
			} catch (final SQLException e) {
				e.printStackTrace();
			}
			return false ;
		}
		
		private boolean generateMap(InputStream fr, int level){
			int i = 0 ;
			try {
				i = fr.read() ;
				int x = 1 ;
				int y = 1 ;
				char c ;
				do{			//	System.out.println("---------------------BEGIN---------------------") ;
					c = (char) i ;
					if (c != '\n'){
						if (c != '\r'){
							if (c != ' '){
								insertCase(level, x, y, c);
							}
							x++ ;
						}
						else{
							x = 1 ;
						}
					}
					else{
						x = 1 ;
						y++ ;
					}
					i = fr.read();
				}			//	System.out.println("----------------------END----------------------") ;
				while (i != -1) ;
				return true ;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false ;
		}
		
		private String determineSprite(char element){
			switch(element){
				case 'I' : return "V-bone";				// Bone
				case '-' : return "H-bone";				// Bone
				case 'O' : return "Bone";				// Bone
				case '1' : return "Purse";					// Purse
				case '2' : return "Flacon";					// Flacon
				case '3' : return "Candlestick";			// Candlestick
				case '4' : return "Purse";					// Chalice
				case 'W' : return "Idol";					// Idol
				case '@' : return "Player";				// Lorann
				case 'A' : return "Monster-1";				// Monster
				case 'B' : return "Monster-2";				// Monster
				case 'C' : return "Monster-3";				// Monster
				case 'D' : return "Monster-4";				// Monster
				case 'Q' : return "Crystal-ball";		// End (Crystal-ball)
				case 'Y' : return "Gate-Close";					// Exit (Gate)
				case '#' : return "Bloc";				// Bloc which are activate (disparition of the bloc) when Lorann touch de Crystall-ball
				case '+' : return "Grave";					// Grave (= Tombe)
				default : System.out.println("A sprite was detected, but she hasn't got a reference in the Database");	break ;
			}
			return null ;
		}
		
		private int recupIntQueryWithOneParameter(final String sql, final String param){
			int integer = 0 ;
			try {
				final CallableStatement call = this.getConnection().prepareCall(sql);
				call.setString(1, param);
				call.execute();
				final ResultSet resultSet = call.getResultSet();
				if (resultSet.first()) {
					integer = resultSet.getInt(1);
				}
				return integer;
			} catch (final SQLException e) {
				e.printStackTrace();
			}
			return -1;
		}
		
		private boolean insertCaseMap(final String sql, final int id_level, final int posX, final int posY, final int id_sprite){
			try {
				final CallableStatement call = this.getConnection().prepareCall(sql);
				call.setInt(1, id_level);
				call.setInt(2, posX);
				call.setInt(3, posY);
				call.setInt(4, id_sprite);
				call.execute();
				return true ;
			} catch (final SQLException e) {
				e.printStackTrace();
			}
			return false;	
		}
}
