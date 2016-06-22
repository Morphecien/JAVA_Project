package behaviors;

import contract.Movement;
import elementsMobile.TypeEndMove;

public class IA_ChoosePlayerDirection_MagicBall extends Behaviors{
	
	public IA_ChoosePlayerDirection_MagicBall(){
		super() ;
	}
	
	public void autoMovement() {
		Movement lastDirection = this.getMobile().getDirection();
		this.choosePlayerDirection() ;
		this.movement();
		if (this.getMobile().getEndMove() == TypeEndMove.BLOCKING){
			this.movementBounce();
			if (this.getMobile().getEndMove() == TypeEndMove.BLOCKING){
				this.getMobile().setDirection(lastDirection);
				this.movement();
			}
		}
	}
}
