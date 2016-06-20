package elementsMobile;

import elementsAll.Sprite;

public class Maarcg extends Monster {
	
	public Maarcg() {
		super(new Sprite("D", "monster_4.png"), "Monster-4", 300);
	//	System.out.println("monster's world : " + this.getWorld()) ;
	}

	public void initIA(){
		this.setIA_behavior(new IA_FullRandom(this));
		System.out.println("IA activée");
	}

	@Override
	public void autoMovement() {
		this.getIA_behavior().autoMovement();
		
	}
}
