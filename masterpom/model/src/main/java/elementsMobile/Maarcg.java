package elementsMobile;

import behaviors.BehaviorsInstances;
import contract.Movement;
import elementsAll.Sprite;

public class Maarcg extends Monster {
	
	public Maarcg() {
		super(new Sprite("D", "monster_4.png"), "Monster-4", 150);
	}

	public void initIA(){
	//	this.setIA_behavior(BehaviorsInstances.IA_CHOOSE_PLAYER_DIRECTION_IF_VIEW_PLAYER);
		this.setIA_behavior(BehaviorsInstances.IA_CHOOSE_PLAYER_DIRECTION);
	}

	@Override
	public synchronized void autoMovement() {
	/*	this.initIA() ;
		this.getIA_behavior().autoMovement();
		if ((this.getDirection() == Movement.NOPE) || (this.getEndMove() == TypeEndMove.BLOCKING)){
			this.setIA_behavior(BehaviorsInstances.IA_FULL_RANDOM);
			this.getIA_behavior().autoMovement();
		}*/
		if ((this.getDirection() == Movement.NOPE) || (this.getEndMove() == TypeEndMove.BLOCKING)){
			this.setIA_behavior(BehaviorsInstances.IA_CHOOSE_PLAYER_DIRECTION);
		}
		else {
			this.setIA_behavior(BehaviorsInstances.IA_SIMPLE_MOVEMENT);
		}
		this.getIA_behavior().autoMovement();
	}
}
