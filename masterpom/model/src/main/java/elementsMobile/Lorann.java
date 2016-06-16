package elementsMobile;

import java.awt.Point;

import elementsAll.Sprite;

public class Lorann extends Mobile {
	private final Point lastPosition ;
	
	public Lorann() {
		super(new Sprite("@", "lorann_ur.png"));
		this.lastPosition = new Point() ;
		this.lastPosition.setLocation(this.getPosition().x, this.getPosition().y);
	}
	
	private void saveLastPosition() {
		if ((this.lastPosition.getX() != this.getPosition().getX()) || (this.lastPosition.getY() != this.getPosition().getY())){
			this.lastPosition.setLocation(this.getPosition().getX(), this.getPosition().getY());
		}
	}
	
	@Override
	public void moveUp() {
		this.saveLastPosition();
		super.moveUp();
	}

	@Override
	public void moveLeft() {
		this.saveLastPosition();
		super.moveLeft();
	}

	@Override
	public void moveDown() {
		this.saveLastPosition();
		super.moveDown();
	}

	@Override
	public void moveRight() {
		this.saveLastPosition();
		super.moveRight();
	}
	
	public void moveBack() {
		this.setX(this.lastPosition.x);
		this.setY(this.lastPosition.y);
	}
}
