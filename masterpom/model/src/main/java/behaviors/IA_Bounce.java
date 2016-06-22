package behaviors;

import elementsMobile.TypeEndMove;

public class IA_Bounce extends Behaviors{	
	public IA_Bounce(){
		super() ;
	}
	
	public void autoMovement() {
		this.movement();
		if (this.getMobile().getEndMove() == TypeEndMove.BLOCKING){
			this.movementBounce();
			if (this.getMobile().getEndMove() == TypeEndMove.TRUE){
				this.getMobile().setEndMove(TypeEndMove.BOUNCE) ;
			}
		}
	}
}
