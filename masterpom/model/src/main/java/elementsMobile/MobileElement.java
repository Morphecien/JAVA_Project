package elementsMobile;

import java.awt.Point;

import elementsAll.Element;
import elementsAll.ISprite;
import elementsAll.Permeability;
import world.Iworld;

public abstract class MobileElement extends Element{
	private final Point position ;
	private final String fileSymbol ;
	private boolean endMove;

	public MobileElement(ISprite sprite, final String fileSymbol) {
		super(sprite, Permeability.BLOCKING);
		this.position = new Point() ;
		this.fileSymbol = fileSymbol ;
		this.endMove = true ;
	}
	
	public MobileElement(ISprite sprite, Permeability permea, final String fileSymbol) {
		super(sprite, permea);
		this.position = new Point() ;
		this.fileSymbol = fileSymbol ;
		this.endMove = true ;
	}
	
	public String getFileSymbol() {
		return this.fileSymbol;
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
	
	public boolean isEndMove() {
		return endMove;
	}

	public void setEndMove(boolean endMove) {
		this.endMove = endMove;
	}
	
	protected void setX(final int x){
		if ((x>=0) && (x < this.getWorld().getWidth())){
			this.getPosition().x = x ;
		}
	}
	
	protected void setY(final int y){
		if ((y>=0) && (y < this.getWorld().getHeight())){
			this.getPosition().y = y ;
		}
	}
	
	public void setWorld(final Iworld world, final int x, final int y) {
		super.setWorld(world);
		this.setX(x);
		this.setY(y);
	}
	
	private void movePossible(final int x, final int y){
		Permeability permeabilityMotionless = this.getWorld().getElementXY(x, y).getPermeability() ;
		Permeability permeabilityMobile = Permeability.PENETRABLE;
		int size = this.getWorld().getMobiles().size() ;
		int i = 0 ;
		int j = 0 ;
		for (int k = 0 ; k < size ; k++){
			MobileElement mobile2 = this.getWorld().getMobiles().get(k) ;
			i = mobile2.getX() ;
			j = mobile2.getY() ;
			if ((i == x) && (j == y)){
				permeabilityMobile = mobile2.getPermeability() ;
			}
		}
		if ((permeabilityMotionless != Permeability.BLOCKING) && (permeabilityMobile != Permeability.BLOCKING)){
			setEndMove(true) ;
		}
		else{
			setEndMove(false) ;
		}
	}
	
	public void moveUp() {
		this.movePossible(this.getX(), this.getY() - 1) ;
		if (this.isEndMove()) {
			this.setY(this.getY() - 1);
		}
	}
	
	public void moveUpLeft() {
		this.movePossible(this.getX() - 1, this.getY() - 1) ;
		if (this.isEndMove()) {
			this.setX(this.getX() - 1);
			this.setY(this.getY() - 1);
		}
	}

	public void moveLeft() {
		this.movePossible(this.getX() - 1, this.getY()) ;
		if (this.isEndMove()) {
			this.setX(this.getX() - 1);
		}
	}
	
	public void moveDownLeft() {
		this.movePossible(this.getX() - 1, this.getY() + 1) ;
		if (this.isEndMove()) {
			this.setX(this.getX() - 1);
			this.setY(this.getY() + 1);
		}
	}

	public void moveDown() {
		this.movePossible(this.getX(), this.getY() + 1) ;
		if (this.isEndMove()) {
			this.setY(this.getY() + 1);
		}
	}
	
	public void moveDownRight() {
		this.movePossible(this.getX() + 1, this.getY() + 1) ;
		if (this.isEndMove()) {
			this.setX(this.getX() + 1);
			this.setY(this.getY() + 1);
		}
	}

	public void moveRight() {
		this.movePossible(this.getX() + 1, this.getY()) ;
		if (this.isEndMove()) {
			this.setX(this.getX() + 1);
		}
	}
	
	public void moveUpRight() {
		this.movePossible(this.getX() + 1, this.getY() - 1) ;
		if (this.isEndMove()) {
			this.setX(this.getX() + 1);
			this.setY(this.getY() - 1);
		}
	}
	
	protected abstract void isMobileDie(final int xDirection, final int yDirection) ;
	protected abstract void isMobileKill(final int xDirection, final int yDirection) ;
}
