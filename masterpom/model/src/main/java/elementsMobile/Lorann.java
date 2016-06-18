package elementsMobile;

import java.awt.Point;

import elementsAll.Sprite;

public class Lorann extends MobileElement {
	private final Point lastPosition ;
	private int score ;
	private int life ;
	
	public Lorann() {
		super(new Sprite("@", "lorann_ur.png"), "Player");
		this.score = 0 ;
		this.life = 11 ;
		this.lastPosition = new Point() ;
		this.lastPosition.setLocation(this.getPosition().x, this.getPosition().y);
	}
	
	private void saveLastPosition() {
		if ((this.lastPosition.getX() != this.getPosition().getX()) || (this.lastPosition.getY() != this.getPosition().getY())){
			this.lastPosition.setLocation(this.getPosition().getX(), this.getPosition().getY());
		}
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
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
