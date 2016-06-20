package elementsMobile;

public class IA_FullRandom extends Behaviors{
	private Monster monster ;
	public IA_FullRandom(Monster mobile){
		super((MobileAuto) mobile) ;
		this.setMonster(mobile);
	}

	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
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
