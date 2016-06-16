package elementsMobile;

import java.awt.Point;

import elementsAll.Element;
import elementsAll.ISprite;
import elementsAll.Permeability;
import world.Iworld;

public class Mobile extends Element{
	private final Point position ;

	public Mobile(ISprite sprite, Permeability permeability) {
		super(sprite, permeability);
		this.position = new Point() ;
	}
	
	public Point getPosition(){
		return this.position ;
	}
	
	public int getX(){
		return this.getPosition().x ;
	}
	
	public int getY(){
		return this.getPosition().y ;
	}
	
	protected void setX(final int x){
		if ((x>=0) && (x < this.getWorld().getWidth())){
			this.getPosition().x = x ;
			this.getWorld().setMobileHasChanged() ;
		}
	}
	
	protected void setY(final int y){
		if ((y>=0) && (y < this.getWorld().getHeight())){
			this.getPosition().y = y ;
			this.getWorld().setMobileHasChanged() ;
		}
	}
	
	public void setWorld(final Iworld world, final int x, final int y) {
		super.setWorld(world);
		this.setX(x);
		this.setY(y);
	}
	
	
}
