package elementsMobile;

public class IA_Bounce extends Behaviors{	
	public IA_Bounce(MobileAuto mobile){
		super(mobile) ;
	}
	
	public void autoMovement() {
		this.movement();
		if (this.getMobile().isEndMove() == false){
			this.inverseDirection(this.getMobile().getDirection());
			this.movement();
		}
	}

}
