package behaviors;

import elementsMobile.TypeEndMove;

public class IA_ChoosePlayerDirection extends Behaviors{	
	public IA_ChoosePlayerDirection(){
		super() ;
	}

	public void autoMovement(){
	//	Movement lastDirection = this.getMobile().getDirection();
		this.choosePlayerDirection() ;
		this.movement();
		if (this.getMobile().getEndMove() == TypeEndMove.BLOCKING){
			this.randomDirectionPossibilities();
			this.movementChooseToPlayerDirection();
			this.movement();
			
		/*	this.movementBounce();
			if (this.getMobile().getEndMove() == TypeEndMove.BLOCKING){
				this.getMobile().setDirection(lastDirection);
				this.movement();
			}*/
		}
	}
	
	
}

/*Movement lastDirection = this.getMobile().getDirection();
this.choosePlayerDirection() ;
this.movement();
if (this.getMobile().getEndMove() == TypeEndMove.BLOCKING){
	this.movementBounce();
	if (this.getMobile().getEndMove() == TypeEndMove.BLOCKING){
		this.getMobile().setDirection(lastDirection);
		this.movement();
	}
}*/