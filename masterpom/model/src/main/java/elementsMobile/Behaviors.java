package elementsMobile;

import java.util.Random;

import contract.Movement;
import elementsAll.Permeability;
import model.Iworld;

public abstract class Behaviors implements IBehavior{
	private MobileAuto mobile ;
	private Iworld world ;
	
	protected Behaviors(MobileAuto mobile){
		this.setMobile(mobile);
		this.setWorld(this.getMobile().getWorld());
	}

	protected MobileAuto getMobile() {
		return mobile;
	}

	protected void setMobile(MobileAuto mobile) {
		this.mobile = mobile;
	}

	protected Iworld getWorld() {
		return world;
	}

	protected void setWorld(Iworld world) {
		this.world = world;
	}
	
	protected void chooseRandomDirection(){
		Random rand = new Random() ;
		final int randMoov = rand.nextInt(9);
		switch(randMoov){
			case 0 : 	this.getMobile().setDirection(Movement.UP); 		break ;
			case 1 : 	this.getMobile().setDirection(Movement.UP_LEFT); 	break ;
			case 2 : 	this.getMobile().setDirection(Movement.LEFT); 		break ;
			case 3 : 	this.getMobile().setDirection(Movement.DOWN_LEFT); 	break ;
			case 4 : 	this.getMobile().setDirection(Movement.DOWN); 		break ;
			case 5 : 	this.getMobile().setDirection(Movement.DOWN_RIGHT); break ;
			case 6 : 	this.getMobile().setDirection(Movement.RIGHT); 		break ;
			case 7 : 	this.getMobile().setDirection(Movement.UP_RIGHT); 	break ;
			case 8 : 	this.getMobile().setDirection(Movement.NOPE); 		break ;
		}
	}
	
	protected boolean randomMovePossible(){
		if (this.getWorld().getElementXY(this.getMobile().getX(), this.getMobile().getY()-1).getPermeabilityOther() == Permeability.PENETRABLE){
			return true ;
		}
		else if(this.getWorld().getElementXY(this.getMobile().getX()-1, this.getMobile().getY()-1).getPermeabilityOther() == Permeability.PENETRABLE){
			return true ;
		}
		else if(this.getWorld().getElementXY(this.getMobile().getX()-1, this.getMobile().getY()).getPermeabilityOther() == Permeability.PENETRABLE){
			return true ;
		}
		else if(this.getWorld().getElementXY(this.getMobile().getX()-1, this.getMobile().getY()+1).getPermeabilityOther() == Permeability.PENETRABLE){
			return true ;
		}
		else if(this.getWorld().getElementXY(this.getMobile().getX(), this.getMobile().getY()+1).getPermeabilityOther() == Permeability.PENETRABLE){
			return true ;
		}
		else if(this.getWorld().getElementXY(this.getMobile().getX()+1, this.getMobile().getY()+1).getPermeabilityOther() == Permeability.PENETRABLE){
			return true ;
		}
		else if(this.getWorld().getElementXY(this.getMobile().getX()+1, this.getMobile().getY()).getPermeabilityOther() == Permeability.PENETRABLE){
			return true ;
		}
		else if(this.getWorld().getElementXY(this.getMobile().getX()+1, this.getMobile().getY()-1).getPermeabilityOther() == Permeability.PENETRABLE){
			return true ;
		}
		return false ;
	}
	
	public void movement(){
		switch(this.getMobile().getDirection()){
			case UP : 			this.getMobile().moveUp();
								this.getMobile().isMobileAction(0, -1) ;
										break ;
			case UP_LEFT : 		this.getMobile().moveUpLeft();
								this.getMobile().isMobileAction(-1, -1) ;
										break ;
			case LEFT : 		this.getMobile().moveLeft();
								this.getMobile().isMobileAction(-1, 0) ;
										break ;
			case DOWN_LEFT : 	this.getMobile().moveDownLeft();
								this.getMobile().isMobileAction(-1, 1) ;
										break ;
			case DOWN : 		this.getMobile().moveDown();
								this.getMobile().isMobileAction(0, 1) ;
										break ;
			case DOWN_RIGHT : 	this.getMobile().moveDownRight();
								this.getMobile().isMobileAction(1, 1) ;
										break ;
			case RIGHT : 		this.getMobile().moveRight();
								this.getMobile().isMobileAction(1, 0) ;
										break ;
			case UP_RIGHT : 	this.getMobile().moveUpRight();
								this.getMobile().isMobileAction(1, -1) ;
										break ;
			case NOPE : 		this.getMobile().setEndMove(true);
										break ;
			default : 					break ;
		}
	}
	
	public void inverseDirection(Movement direction){
		switch(direction){
			case UP : 			this.getMobile().setDirection(Movement.DOWN) ;
										break ;
			case UP_LEFT : 		this.getMobile().setDirection(Movement.DOWN_RIGHT) ;
										break ;
			case LEFT : 		this.getMobile().setDirection(Movement.RIGHT) ;
										break ;
			case DOWN_LEFT : 	this.getMobile().setDirection(Movement.UP_RIGHT) ;
										break ;
			case DOWN : 		this.getMobile().setDirection(Movement.UP) ;
										break ;
			case DOWN_RIGHT : 	this.getMobile().setDirection(Movement.UP_LEFT) ;
										break ;
			case RIGHT : 		this.getMobile().setDirection(Movement.LEFT) ;
										break ;
			case UP_RIGHT : 	this.getMobile().setDirection(Movement.DOWN_LEFT) ;
										break ;
			case NOPE : 				break ;
			default : 					break ;
		}
	}
}
