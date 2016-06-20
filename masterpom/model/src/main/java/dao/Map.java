package dao;
/**
 * 
 * @author Asus
 *
 */
public class Map extends Entity{
	private String[][] map ;
	public Map() {
		this.map = new String[12][20] ;
	}
	/**
	 * 
	 * @return
	 */
	public String[][] getMap(){
		return this.map ;
	}
	/**
	 * 
	 * @param map
	 */
	public void setMap(String[][] map){
		this.map = map ;
	}

}
