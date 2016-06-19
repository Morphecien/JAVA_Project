package elementsMobile;

import elementsAll.ISprite;

public class Monster extends MobileAuto implements ImonsterBehavior {

	public Monster(ISprite sprite, final String monster) {
		super(sprite, monster);
	}

	public void movement() {
		
	}
	
	@Override
	public void moveUp() {
		super.moveUp();
		this.isMobileDie(0, -1) ;
	}
	
	@Override
	public void moveUpLeft() {
		super.moveUpLeft();
		this.isMobileDie(-1, -1) ;
	}

	@Override
	public void moveLeft() {
		super.moveLeft();
		this.isMobileDie(-1, 0) ;
	}
	
	@Override
	public void moveDownLeft() {
		super.moveDownLeft();
		this.isMobileDie(-1, 1) ;
	}

	@Override
	public void moveDown() {
		super.moveDown();
		this.isMobileDie(0, 1) ;
	}
	
	@Override
	public void moveDownRight() {
		super.moveDownRight();
		this.isMobileDie(1, 1) ;
	}

	@Override
	public void moveRight() {
		super.moveRight();
		this.isMobileDie(1, 0) ;
	}
	
	@Override
	public void moveUpRight() {
		super.moveUpRight();
		this.isMobileDie(1, -1) ;
	}
	

	@Override
	protected void isMobileDie(final int xDirection, final int yDirection) {	// Monster Die (MagicBall)
		
	}

	@Override
	protected void isMobileKill(int xDirection, int yDirection) { // Lorann Die (Lorann)
		// TODO Auto-generated method stub
		
	}

	@Override
	public void autoMovement() {
		// TODO Auto-generated method stub
		
	}
}
