package behaviors;

public class IA_FullRandom extends Behaviors{
	public IA_FullRandom(){
		super() ;
	}

	public void autoMovement() {
		this.randomMove();
		this.movement();
	}
}
