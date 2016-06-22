package elementsMobile;

import behaviors.BehaviorsInstances;
import elementsAll.Sprite;

public class Kyrackj extends Monster{

	public Kyrackj() {
		super(new Sprite("A", "monster_1.png"), "Monster-1", 500);
		
	}

	public void initIA(){
		this.setIA_behavior(BehaviorsInstances.IA_FULL_RANDOM);
	}

	@Override
	public synchronized void autoMovement() {
		this.getIA_behavior().autoMovement();
	}
}
