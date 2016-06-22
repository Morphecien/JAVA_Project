package behaviors;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import contract.Movement;
import elementsAll.Permeability;
import elementsMobile.MobileAuto;
import elementsMobile.TypeEndMove;
import movements.CoordDeplacement;
import movements.Position;

public abstract class Behaviors implements IBehavior{
	private MobileAuto mobile ;
	private ArrayList<Movement> movePossibilities ;
	private Random rand = new Random() ;
	
	protected Behaviors(){
		movePossibilities = new ArrayList<Movement>() ;
	}
	
	public void initBehavior(){
		this.setMobile(mobile);
	}

	protected MobileAuto getMobile() {
		return mobile;
	}

	public void setMobile(MobileAuto mobile) {
		this.mobile = mobile;
	}
	
	/**
	 * @return the rand
	 */
	public Random getRand() {
		return rand;
	}

	/**
	 * @return the movePossibilities
	 */
	public ArrayList<Movement> getMovePossibilities() {
		return movePossibilities;
	}

	/**
	 * @param movePossibilities the movePossibilities to set
	 */
	public void setMovePossibilities(ArrayList<Movement> movePossibilities) {
		this.movePossibilities = movePossibilities;
	}
	
	public void re_init_MovePossibilities(){
		this.getMovePossibilities().removeAll(getMovePossibilities()) ;
		this.getMovePossibilities().add(Movement.NOPE) ;
	}

	protected void chooseRandomDirection(){
		if (this.getMovePossibilities().size() < 1){	// Si pas de mouvement enregistré
			this.getMovePossibilities().add(CoordDeplacement.NOPE.getDirection()) ;
		}
		final int randMoov = this.getRand().nextInt(this.getMovePossibilities().size());
		this.getMobile().setDirection(this.getMovePossibilities().get(randMoov)) ;
	}
	
	protected void randomDirectionPossibilities(){
		this.re_init_MovePossibilities();
		if (this.getMobile().getWorld().getElementXY(this.getMobile().getX(), this.getMobile().getY()-1).getPermeabilityOther() == Permeability.PENETRABLE){
			this.getMovePossibilities().add(Movement.UP) ;
		}
		if(this.getMobile().getWorld().getElementXY(this.getMobile().getX()-1, this.getMobile().getY()-1).getPermeabilityOther() == Permeability.PENETRABLE){
			this.getMovePossibilities().add(Movement.UP_LEFT) ;
		}
		if(this.getMobile().getWorld().getElementXY(this.getMobile().getX()-1, this.getMobile().getY()).getPermeabilityOther() == Permeability.PENETRABLE){
			this.getMovePossibilities().add(Movement.LEFT) ;
		}
		if(this.getMobile().getWorld().getElementXY(this.getMobile().getX()-1, this.getMobile().getY()+1).getPermeabilityOther() == Permeability.PENETRABLE){
			this.getMovePossibilities().add(Movement.DOWN_LEFT) ;
		}
		if(this.getMobile().getWorld().getElementXY(this.getMobile().getX(), this.getMobile().getY()+1).getPermeabilityOther() == Permeability.PENETRABLE){
			this.getMovePossibilities().add(Movement.DOWN) ;
		}
		if(this.getMobile().getWorld().getElementXY(this.getMobile().getX()+1, this.getMobile().getY()+1).getPermeabilityOther() == Permeability.PENETRABLE){
			this.getMovePossibilities().add(Movement.DOWN_RIGHT) ;
		}
		if(this.getMobile().getWorld().getElementXY(this.getMobile().getX()+1, this.getMobile().getY()).getPermeabilityOther() == Permeability.PENETRABLE){
			this.getMovePossibilities().add(Movement.RIGHT) ;
		}
		if(this.getMobile().getWorld().getElementXY(this.getMobile().getX()+1, this.getMobile().getY()-1).getPermeabilityOther() == Permeability.PENETRABLE){
			this.getMovePossibilities().add(Movement.UP_RIGHT) ;
		}
	}
	
	protected void randomMove(){
		this.randomDirectionPossibilities();
		this.chooseRandomDirection();
	}
	
	protected void choosePlayerDirection(){
		final int xLorann = this.getMobile().getWorld().getLorann().getX();
		final int yLorann = this.getMobile().getWorld().getLorann().getY();
		final int xMobile = this.getMobile().getX();
		final int yMobile = this.getMobile().getY();
		final int xGap = Math.abs(xMobile - xLorann);
		final int yGap = Math.abs(yMobile - yLorann);
		if (yLorann < yMobile){			// UP
			if (xLorann < xMobile){			// LEFT
				if (xGap > yGap*2){					// Choose LEFT
					this.getMobile().setDirection(Movement.LEFT) ;
				}
				else if (yGap > xGap*2){			// Choose UP
					this.getMobile().setDirection(Movement.UP) ;
				}
				else{								// Choose UP_LEFT
					this.getMobile().setDirection(Movement.UP_LEFT) ;
				}
			}
			else if (xLorann > xMobile){		// RIGHT
				if (xGap > yGap*2){					// Choose RIGHT
					this.getMobile().setDirection(Movement.RIGHT) ;
				}
				else if (yGap > xGap*2){			// Choose UP
					this.getMobile().setDirection(Movement.UP) ;
				}
				else{								// Choose UP_RIGHT
					this.getMobile().setDirection(Movement.UP_RIGHT) ;
				}
			}
			else{								// X don't change
				this.getMobile().setDirection(Movement.UP) ;
			}
		}
		else if (yLorann > yMobile){		// DOWN
			if (xLorann < xMobile){			// LEFT
				if (xGap > yGap*2){					// Choose LEFT
					this.getMobile().setDirection(Movement.LEFT) ;
				}
				else if (yGap > xGap*2){			// Choose DOWN
					this.getMobile().setDirection(Movement.DOWN) ;
				}
				else{								// Choose DOWN_LEFT
					this.getMobile().setDirection(Movement.DOWN_LEFT) ;
				}
			}
			else if (xLorann > xMobile){		// RIGHT
				if (xGap > yGap*2){					// Choose RIGHT
					this.getMobile().setDirection(Movement.RIGHT) ;
				}
				else if (yGap > xGap*2){			// Choose DOWN
					this.getMobile().setDirection(Movement.DOWN) ;
				}
				else{								// Choose DOWN_RIGHT
					this.getMobile().setDirection(Movement.DOWN_RIGHT) ;
				}
			}
			else{								// X don't change
				this.getMobile().setDirection(Movement.DOWN) ;
			}
		}
		else {								// Y don't change
			if (xLorann < xMobile){			// LEFT
				this.getMobile().setDirection(Movement.LEFT) ;
			}
			else if (xLorann > xMobile){		// RIGHT
				this.getMobile().setDirection(Movement.RIGHT) ;
			}
			else{								// X don't change
				this.getMobile().setDirection(Movement.NOPE) ;
			}
		}
	}

	protected void movementChooseToPlayerDirection(){
		if (this.getMovePossibilities().size() > 1){
			this.getMovePossibilities().remove(Movement.NOPE) ;
		}
		Point actualMobilePoint = this.getMobile().getPosition() ;
		Point actualLorannPoint = this.getMobile().getWorld().getLorann().getPosition() ;
		ArrayList<Movement> bestPositions = new ArrayList<Movement>() ;
		Position positionFirstCheck = CoordDeplacement.determinePositionMovement(this.getMovePossibilities().get(0)) ;
		Position positionTestCheck = null ;
		int xGap = Math.abs(actualLorannPoint.x - positionFirstCheck.getxDeplacement()) ;
		int yGap = Math.abs(actualLorannPoint.y - positionFirstCheck.getyDeplacement()) ;
		double gapBest = Math.sqrt(Math.pow(xGap, 2) + Math.pow(yGap, 2)) ;
		int xGapCheck = 0 ;
		int yGapCheck = 0 ;
		double gapCheck = 0 ;
		for (int i = 0 ; i < this.getMovePossibilities().size() ; i++){
			positionTestCheck = CoordDeplacement.determinePositionMovement(this.getMovePossibilities().get(i)) ;
			xGapCheck = Math.abs(actualLorannPoint.x - (actualMobilePoint.x + positionTestCheck.getxDeplacement())) ;
			yGapCheck = Math.abs(actualLorannPoint.y - (actualMobilePoint.y + positionTestCheck.getyDeplacement())) ;
			gapCheck = Math.sqrt(Math.pow(xGapCheck, 2) + Math.pow(yGapCheck, 2)) ;
	//		System.out.println("Check n°" + i + " : " + positionTestCheck.getDirection() + " (gap : " + gapCheck + ") x=" + xGapCheck + " & y=" + yGapCheck + " x²=" + (Math.pow(xGapCheck, 2)) + " & y²=" + (Math.pow(yGapCheck, 2)));
			if (gapCheck < gapBest){
				gapBest = gapCheck ;
				bestPositions.removeAll(bestPositions) ;
				bestPositions.add(positionTestCheck.getDirection()) ;
			}
			else if (gapCheck == gapBest){
				bestPositions.add(positionTestCheck.getDirection()) ;
			}
		}
	//	this.afficherBestsPossibilities(bestPositions);
		this.getMovePossibilities().removeAll(this.getMovePossibilities()) ;
		this.getMovePossibilities().addAll(bestPositions) ;
		this.chooseRandomDirection();
	//	System.out.println("Direction choisie : " + this.getMobile().getDirection()) ;
		
	}

	protected void movement(){
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
			case NOPE : 		this.getMobile().setEndMove(TypeEndMove.TRUE);
										break ;
			default : 					break ;
		}
	}
	
	protected void movementBounce(){
		this.getMobile().setDirection(Behaviors.inverseDirection(this.getMobile().getDirection()));
		this.movement();
		if (this.getMobile().getEndMove() == TypeEndMove.TRUE){
			this.getMobile().setEndMove(TypeEndMove.BOUNCE) ;
		}
	}
	
	public static Movement inverseDirection(Movement direction){
		switch(direction){
			case UP : 			return Movement.DOWN ;
			case UP_LEFT : 		return Movement.DOWN_RIGHT ;
			case LEFT : 		return Movement.RIGHT ;
			case DOWN_LEFT : 	return Movement.UP_RIGHT ;
			case DOWN : 		return Movement.UP ;
			case DOWN_RIGHT : 	return Movement.UP_LEFT ;
			case RIGHT : 		return Movement.LEFT ;
			case UP_RIGHT : 	return Movement.DOWN_LEFT ;
			case NOPE : 		return Movement.NOPE ;
			default : 			return Movement.NOPE ;
		}
	}

	protected void afficherMovementsPossibilities(){
		int size = this.getMovePossibilities().size() ;
		System.out.println("Affichage de l'ArrayList d'éléments mobiles, qui contient " + size + " éléments :");
		for (int i = 0 ; i< size ; i++){
			System.out.println("\tPosition n°" + i + " - " + this.getMovePossibilities().get(i));
		}
		System.out.println() ;
	}

	protected void afficherBestsPossibilities(ArrayList<Movement> bestPositions){
		int size = bestPositions.size() ;
		System.out.println("Affichage de l'ArrayList d'éléments mobiles, qui contient " + size + " éléments :");
		for (int i = 0 ; i< size ; i++){
			System.out.println("\tPosition n°" + i + " - " + bestPositions.get(i));
		}
		System.out.println() ;
	}
}
