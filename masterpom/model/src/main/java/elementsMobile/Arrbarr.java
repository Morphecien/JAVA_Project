package elementsMobile;

import behaviors.BehaviorsInstances;
import elementsAll.Sprite;

public class Arrbarr extends Monster {
	
	public Arrbarr() {
		super(new Sprite("C", "monster_3.png"), "Monster-3", 300);
		
	}

	public void initIA(){
		this.setIA_behavior(BehaviorsInstances.IA_CHOOSE_PLAYER_DIRECTION);
	}

	@Override
	public synchronized void autoMovement() {
		this.getIA_behavior().autoMovement();
	}
}
