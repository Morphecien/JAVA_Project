package world;

import elementsMotionless.*;

public class WorldAnswer {
	private World world ;
	public WorldAnswer(World world){
		this.world = world ;
	}
	
	public World getWorld(){
		return this.world ;
	}
	
	public void getWorldAnswer(){
		final IElementsActionOnHeroes element = this.getWorld().getElementXY(this.getWorld().getLorann().getX(), this.getWorld().getLorann().getY());

		switch (element.getElementActionOnHeroes()) {
			case COLLECT:
				System.out.println("COLLECT !!!! (:");
				this.resolveCollectTreasure((Itreasures) element);
				break;
			case NEWLIFE:
				System.out.println("NEW LIFE !!!! (:");
				this.resolveObtainNewLife();
				break;
			case DIE:
				System.out.println("DIE !!!! ):");
				this.resolveLorannDie();
				break;
			case UNLOCKS_GATE:
				System.out.println("GATE --> OPEN !!!! (:");
				this.resolveUnlocksGate();
				break;
			case NOPE:
			default:
				break;
		}
	}
	private void resolveCollectTreasure(Itreasures element){
	//	System.out.print("score : " + this.getWorld().getLorann().getScore() + " | new ");
		final int score = this.getWorld().getLorann().getScore() + element.collectTreasure() ;
		this.getWorld().getLorann().setScore(score) ;
		System.out.println("score : " + this.getWorld().getLorann().getScore());
		this.getWorld().dropElement(this.getWorld().getLorann().getX(), this.getWorld().getLorann().getY());
	}
	
	private void resolveObtainNewLife(){
		System.out.print("Lifes : " + this.getWorld().getLorann().getLife() + " | new ");
		final int life = this.getWorld().getLorann().getLife() + 1 ;
		this.getWorld().getLorann().setLife(life) ;
		System.out.println("Lifes : " + this.getWorld().getLorann().getLife());
		this.getWorld().dropElement(this.getWorld().getLorann().getX(), this.getWorld().getLorann().getY());
	}
	
	private void resolveLorannDie(){
		
	}
	
	private void resolveUnlocksGate(){
		this.getWorld().dropElement(this.getWorld().getLorann().getX(), this.getWorld().getLorann().getY());
	//	this.getWorld().dropElement(MotionlessDetermineElement.GATEOPEN, this.getWorld().searchGate().x, this.getWorld().searchGate().y);
	//	afficherWorld() ;
		System.out.println(this.getWorld().getElementXY(2, 3).getSprite().getImage());
	//	this.getWorld().setMobileHasChanged();
		this.getWorld().notifyObservers();
	}
		
	private void afficherWorld(){
		for (int y=0 ; y<12 ; y++){
			for (int x=0 ; x<20 ; x++){
				System.out.print(this.getWorld().getElementXY(x, y).getSprite()) ;
			}
			System.out.println() ;
		}
		System.out.println(this.getWorld().getElementXY(2, 3).getSprite().getTest());
	}
}
