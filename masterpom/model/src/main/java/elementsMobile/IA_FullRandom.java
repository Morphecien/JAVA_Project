package elementsMobile;

public class IA_FullRandom extends Behaviors{
	public IA_FullRandom(MobileAuto mobile){
		super((MobileAuto) mobile) ;
	}

	public void autoMovement() {
		if (this.randomMovePossible()){
			do {
				this.chooseRandomDirection();
				this.movement();
			}
			while (this.getMobile().isEndMove() == false) ;
		}
	}
}
