package elementsMobile;

import java.util.Random;

import contract.Movement;
import elementsAll.ISprite;
import elementsAll.Permeability;

public abstract class Monster extends MobileAuto {
	private IBehavior IA_behavior ;

	public Monster(ISprite sprite, final String monsterSymbol, final int delayAction) {
		super(sprite, monsterSymbol, delayAction);
		this.initialize();
	}
	
	public IBehavior getIA_behavior() {
		return IA_behavior;
	}

	public void setIA_behavior(IBehavior IA_behavior) {
		this.IA_behavior = IA_behavior;
	}
	
	public abstract void initIA() ;

	protected void chooseRandomDirection(){
		Random rand = new Random() ;
		final int randMoov = rand.nextInt(9);
		switch(randMoov){
			case 0 : 	this.setDirection(Movement.UP); 		break ;
			case 1 : 	this.setDirection(Movement.UP_LEFT); 	break ;
			case 2 : 	this.setDirection(Movement.LEFT); 		break ;
			case 3 : 	this.setDirection(Movement.DOWN_LEFT); 	break ;
			case 4 : 	this.setDirection(Movement.DOWN); 		break ;
			case 5 : 	this.setDirection(Movement.DOWN_RIGHT); break ;
			case 6 : 	this.setDirection(Movement.RIGHT); 		break ;
			case 7 : 	this.setDirection(Movement.UP_RIGHT); 	break ;
			case 8 : 	this.setDirection(Movement.NOPE); 		break ;
		}
	}
	
	protected boolean randomMovePossible(){
		if (this.getWorld().getElementXY(this.getX(), this.getY()-1).getPermeabilityOther() == Permeability.PENETRABLE){
			return true ;
		}
		else if(this.getWorld().getElementXY(this.getX()-1, this.getY()-1).getPermeabilityOther() == Permeability.PENETRABLE){
			return true ;
		}
		else if(this.getWorld().getElementXY(this.getX()-1, this.getY()).getPermeabilityOther() == Permeability.PENETRABLE){
			return true ;
		}
		else if(this.getWorld().getElementXY(this.getX()-1, this.getY()+1).getPermeabilityOther() == Permeability.PENETRABLE){
			return true ;
		}
		else if(this.getWorld().getElementXY(this.getX(), this.getY()+1).getPermeabilityOther() == Permeability.PENETRABLE){
			return true ;
		}
		else if(this.getWorld().getElementXY(this.getX()+1, this.getY()+1).getPermeabilityOther() == Permeability.PENETRABLE){
			return true ;
		}
		else if(this.getWorld().getElementXY(this.getX()+1, this.getY()).getPermeabilityOther() == Permeability.PENETRABLE){
			return true ;
		}
		else if(this.getWorld().getElementXY(this.getX()+1, this.getY()-1).getPermeabilityOther() == Permeability.PENETRABLE){
			return true ;
		}
		return false ;
	}
	
	@Override
	protected void isMobileAction(int xDirection, int yDirection) {
		if (this.isEndMove() == false){
			final int size = this.getWorld().getMobiles().size() ;
			int indexKillPlayer = -1 ;
			int indexKillByMagicBall = -1 ;
			for (int k = 0 ; k < size ; k++){
				MobileElement mobile = this.getWorld().getMobiles().get(k) ;
				if ((mobile.getX() == (this.getX() + xDirection)) && (mobile.getY() == (this.getY() + yDirection))){
					if (mobile.getFileSymbol() == "Player"){				// Kill Lorann
						indexKillPlayer = k ;
					}
					else if (mobile.getFileSymbol() == "Magicball"){		// Kill Monster
						indexKillByMagicBall = k ;
					}
				}
			}
			if (indexKillPlayer !=-1){
				MobileElement mobile = this.getWorld().getMobiles().get(indexKillPlayer) ;					// Kill Lorann
				System.out.println("A mobile was died : " + mobile.getFileSymbol());
				this.getWorld().lorannDie();
			}
			else if (indexKillByMagicBall != -1){
				MobileElement mobile = this.getWorld().getMobiles().get(indexKillByMagicBall) ;					// Kill Lorann
				System.out.println("A mobile was died : " + mobile.getFileSymbol());
				this.getWorld().delMobile(indexKillByMagicBall);;
			}
		}
	}
}
