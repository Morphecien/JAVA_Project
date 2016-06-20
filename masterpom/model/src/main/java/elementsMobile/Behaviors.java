package elementsMobile;

import java.util.Random;

import contract.Movement;
import elementsAll.Permeability;
import world.Iworld;

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
			case UP : 			getMobile().moveUp();
								getMobile().isMobileAction(0, -1) ;
										break ;
			case UP_LEFT : 		getMobile().moveUpLeft();
								getMobile().isMobileAction(-1, -1) ;
										break ;
			case LEFT : 		getMobile().moveLeft();
								getMobile().isMobileAction(-1, 0) ;
										break ;
			case DOWN_LEFT : 	getMobile().moveDownLeft();
								getMobile().isMobileAction(-1, 1) ;
										break ;
			case DOWN : 		getMobile().moveDown();
								getMobile().isMobileAction(0, 1) ;
										break ;
			case DOWN_RIGHT : 	getMobile().moveDownRight();
								getMobile().isMobileAction(1, 1) ;
										break ;
			case RIGHT : 		getMobile().moveRight();
								getMobile().isMobileAction(1, 0) ;
										break ;
			case UP_RIGHT : 	getMobile().moveUpRight();
								getMobile().isMobileAction(1, -1) ;
										break ;
			case NOPE : 	//	System.out.println("C'est bien dommage d'en arriver là : NOPE (Le mobile " + this.getFileSymbol() + " ne connait pas sa direction de déplacement)");
										break ;
			default : 					break ;
		}
	}
}
