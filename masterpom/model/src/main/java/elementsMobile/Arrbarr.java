package elementsMobile;

import elementsAll.Sprite;

public class Arrbarr extends Monster {
	
	public Arrbarr() {
		super(new Sprite("C", "monster_3.png"), "Monster-3", 500);
		
	}

	public void initIA(){
		this.setIA_behavior(new IA_FullRandom(this));
	}

	@Override
	public synchronized void autoMovement() {
		this.getIA_behavior().autoMovement();
	}
}
