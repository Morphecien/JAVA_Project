package elementsMobile;

import java.awt.Point;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import elementsAll.Element;
import elementsAll.ISprite;
import elementsAll.Permeability;
import model.Iworld;

public abstract class MobileElement extends Element implements Runnable, ActionListener{
	private final Point position ;
	private final String fileSymbol ;
	private TypeEndMove endMove;
	private Timer timer ;
	private boolean active ;
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public MobileElement(ISprite sprite, final String fileSymbol) {
		super(sprite, Permeability.BLOCKING, Permeability.BLOCKING);
		this.position = new Point() ;
		this.fileSymbol = fileSymbol ;
		this.endMove = TypeEndMove.TRUE ;
	}
	
	public MobileElement(ISprite sprite, Permeability permea, final String fileSymbol) {
		super(sprite, permea, Permeability.BLOCKING);
		this.position = new Point() ;
		this.fileSymbol = fileSymbol ;
		this.endMove = TypeEndMove.TRUE ;
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
	
	public TypeEndMove getEndMove() {
		return this.endMove;
	}

	public void setEndMove(TypeEndMove endMove) {
		this.endMove = endMove;
	}
	
	protected void setX(final int x){
		if ((x>=0) && (x < this.getWorld().getWidth())){
			this.getPosition().x = x ;
		}
		else {
			throw new IllegalArgumentException("The x param is illegal (<0 or >this.getWorld().getWidth");
		}
	}
	
	protected void setY(final int y){
		if ((y>=0) && (y < this.getWorld().getHeight())){
			this.getPosition().y = y ;
		}
		else {
			throw new IllegalArgumentException("The x param is illegal (<0 or >this.getWorld().getWidth");
		}
	}
	
	public void setWorld(final Iworld world, final int x, final int y) {
		super.setWorld(world);
		this.setX(x);
		this.setY(y);
	}
	
	protected abstract void movePossible(final int x, final int y);
	
	public void moveUp() {
		this.movePossible(this.getX(), this.getY() - 1) ;
		if (this.getEndMove() == TypeEndMove.TRUE) {
			this.setY(this.getY() - 1);
		}
	}
	
	public void moveUpLeft() {
		this.movePossible(this.getX() - 1, this.getY() - 1) ;
		if (this.getEndMove() == TypeEndMove.TRUE) {
			this.setX(this.getX() - 1);
			this.setY(this.getY() - 1);
		}
	}

	public void moveLeft() {
		this.movePossible(this.getX() - 1, this.getY()) ;
		if (this.getEndMove() == TypeEndMove.TRUE) {
			this.setX(this.getX() - 1);
		}
	}
	
	public void moveDownLeft() {
		this.movePossible(this.getX() - 1, this.getY() + 1) ;
		if (this.getEndMove() == TypeEndMove.TRUE) {
			this.setX(this.getX() - 1);
			this.setY(this.getY() + 1);
		}
	}

	public void moveDown() {
		this.movePossible(this.getX(), this.getY() + 1) ;
		if (this.getEndMove() == TypeEndMove.TRUE) {
			this.setY(this.getY() + 1);
		}
	}
	
	public void moveDownRight() {
		this.movePossible(this.getX() + 1, this.getY() + 1) ;
		if (this.getEndMove() == TypeEndMove.TRUE) {
			this.setX(this.getX() + 1);
			this.setY(this.getY() + 1);
		}
	}

	public void moveRight() {
		this.movePossible(this.getX() + 1, this.getY()) ;
		if (this.getEndMove() == TypeEndMove.TRUE) {
			this.setX(this.getX() + 1);
		}
	}
	
	public void moveUpRight() {
		this.movePossible(this.getX() + 1, this.getY() - 1) ;
		if (this.getEndMove() == TypeEndMove.TRUE) {
			this.setX(this.getX() + 1);
			this.setY(this.getY() - 1);
		}
	}
	
	public abstract void isMobileAction(final int xDirection, final int yDirection) ;
	
	protected Timer getMoveTimer(){
		return this.timer ;
	}
	
	protected void setMoveTimer(Timer timer){
		this.timer = timer ;
	}
}
