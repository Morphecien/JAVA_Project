package elementsMobile;

import behaviors.BehaviorsInstances;
import contract.Movement;
import elementsAll.Sprite;

public class Cargyv extends Monster {
	
	public Cargyv() {
		super(new Sprite("B", "monster_2.png"), "Monster-2", 500);
	}

	public void initIA(){
		this.setIA_behavior(BehaviorsInstances.IA_CHOOSE_PLAYER_DIRECTION);
	}

	@Override
	public synchronized void autoMovement() {
		if ((this.getDirection() == Movement.NOPE) || (this.getEndMove() == TypeEndMove.BLOCKING)){
			this.setIA_behavior(BehaviorsInstances.IA_CHOOSE_PLAYER_DIRECTION);
		}
		else {
			this.setIA_behavior(BehaviorsInstances.IA_SIMPLE_MOVEMENT);
		}
		this.getIA_behavior().autoMovement();
	}
}
