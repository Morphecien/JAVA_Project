package elementsMobile;

import elementsAll.Sprite;

public class Cargyv extends Monster {
	
	public Cargyv() {
		super(new Sprite("B", "monster_2.png"), "Monster-2", 500);
		
	}

	public void initIA(){
		this.setIA_behavior(new IA_FullRandom(this));
	}

	@Override
	public synchronized void autoMovement() {
		this.getIA_behavior().autoMovement();
	}
}
