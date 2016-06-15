package model;

public class Map extends Entity{
	private String[][] map ;
	public Map() {
		this.map = new String[12][20] ;
	}
	
	public String[][] getMap(){
		return this.map ;
	}
	
	public void setMap(String[][] map){
		this.map = map ;
	}
	
}
