package elementsMobile;

import contract.Movement;
import elementsAll.ISprite;
import elementsAll.Permeability;

public abstract class MobileAuto extends MobileElement{
	private boolean active ;
	private Movement direction ;

	public MobileAuto(ISprite sprite, Permeability permea, String fileSymbol) {
		super(sprite, permea, fileSymbol);
	}
	
	public MobileAuto(ISprite sprite, String fileSymbol) {
		super(sprite, fileSymbol);
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public Movement getDirection() {
		return direction;
	}

	public void setDirection(Movement direction) {
		this.direction = direction;
	}
	
	public void movement(){
		switch(this.getDirection()){
			case UP : 			super.moveUp();
								this.isMobileDie(0, -1);
								this.isMobileKill(0, -1) ;
										break ;
			case UP_LEFT : 		super.moveUpLeft();
								this.isMobileDie(-1, -1) ;
								this.isMobileKill(-1, -1) ;
										break ;
			case LEFT : 		super.moveLeft();
								this.isMobileDie(-1, 0) ;
								this.isMobileKill(-1, 0) ;
										break ;
			case DOWN_LEFT : 	super.moveDownLeft();
								this.isMobileDie(-1, 1) ;
								this.isMobileKill(-1, 1) ;
										break ;
			case DOWN : 		super.moveDown();
								this.isMobileDie(0, 1) ;
								this.isMobileKill(0, 1) ;
										break ;
			case DOWN_RIGHT : 	super.moveDownRight();
								this.isMobileDie(1, 1) ;
								this.isMobileKill(1, 1) ;
										break ;
			case RIGHT : 		super.moveRight();
								this.isMobileDie(1, 0) ;
								this.isMobileKill(1, 0) ;
										break ;
			case UP_RIGHT : 	super.moveUpRight();
								this.isMobileDie(1, -1) ;
								this.isMobileKill(1, -1) ;
										break ;
			case NOPE : 		System.out.println("C'est bien dommage d'en arriver là : NOPE (Le mobile " + this.getFileSymbol() + " ne connait pas sa direction de déplacement");
										break ;
			default : 					break ;
		}
	}
	
	public void inverseDirection(Movement direction){
		switch(direction){
			case UP : 			this.setDirection(Movement.DOWN) ;
										break ;
			case UP_LEFT : 		this.setDirection(Movement.DOWN_RIGHT) ;
										break ;
			case LEFT : 		this.setDirection(Movement.RIGHT) ;
										break ;
			case DOWN_LEFT : 	this.setDirection(Movement.UP_RIGHT) ;
										break ;
			case DOWN : 		this.setDirection(Movement.UP) ;
										break ;
			case DOWN_RIGHT : 	this.setDirection(Movement.UP_LEFT) ;
										break ;
			case RIGHT : 		this.setDirection(Movement.LEFT) ;
										break ;
			case UP_RIGHT : 	this.setDirection(Movement.DOWN_LEFT) ;
										break ;
			case NOPE : 		System.out.println("Ah merde, c'est balot, le mobile " + this.getFileSymbol() + " voudrait changer de direction... mais NOPE, ça veut pas ^^");
								System.out.println("Du coup on va le supprimer !");
						//		this.reinitialize();
								
										break ;
			default : 					break ;
		}
	}
	
	public void activate(Movement direction){
		this.setActive(true);
		this.autoMovement();
	}
	
	protected void initialize(){
		this.setActive(false);
		this.setDirection(Movement.NOPE) ;
	}

	public void reinitialize(){
		this.initialize();
		this.deleteObject();
	}
	
	private void deleteInArrayList(MobileElement element){
		final int size = this.getWorld().getMobiles().size() ;
		int kMobile = 0 ;
		for (int k = 0 ; k < size ; k++){
			MobileElement mobile = this.getWorld().getMobiles().get(k) ;
			if (mobile == element){
				kMobile = k ;
			}
		}
		this.getWorld().delMobile(kMobile);
	}
	
	protected void deleteObject(){
		deleteInArrayList(this) ;
	}
	
	protected void deleteObject(MobileElement element){
		deleteInArrayList(element) ;
	}

	public abstract void autoMovement() ;
}
