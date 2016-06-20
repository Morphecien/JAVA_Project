package elementsMobile;

import elementsAll.Sprite;

public class Maarcg extends Monster {
	
	public Maarcg() {
		super(new Sprite("D", "monster_4.png"), "Monster-4", 300);
	}

	public void initIA(){
		this.setIA_behavior(new IA_FullRandom(this));
	}

	@Override
	public synchronized void autoMovement() {
		this.getIA_behavior().autoMovement();
	}
}
