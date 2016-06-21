package model;

import elementsMotionless.*;

public class WorldAnswer {
	private Iworld world ;
	
	public WorldAnswer(World world){
		this.world = world ;
	}
	
	public Iworld getWorld(){
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
			case UNLOCKS_GATE:
				System.out.println("GATE --> OPEN !!!! (:");
				this.resolveUnlocksGate();
				break;
			case EXIT:
				System.out.println("LEVEL --> END !!!! (:");
				this.resolveEndLevel();
				break;
			case NOPE:
			default:
				break;
		}
		this.getWorld().worldHasChanged() ;
	}
	private void resolveCollectTreasure(Itreasures element){
		System.out.print("score : " + this.getWorld().getLorann().getScore() + " | new ");
		final int score = this.getWorld().getLorann().getScore() + element.collectTreasure() ;
		this.getWorld().getLorann().setScore(score) ;
		System.out.println("Score : " + this.getWorld().getLorann().getScore());
		this.getWorld().dropElement(this.getWorld().getLorann().getX(), this.getWorld().getLorann().getY());
	}
	
	private void resolveObtainNewLife(){
		System.out.print("Lifes : " + this.getWorld().getLorann().getLife() + " | new ");
		final int life = this.getWorld().getLorann().getLife() + 1 ;
		this.getWorld().getLorann().setLife(life) ;
		System.out.println("Lifes : " + this.getWorld().getLorann().getLife());
		this.getWorld().dropElement(this.getWorld().getLorann().getX(), this.getWorld().getLorann().getY());
	}
	
	private void resolveUnlocksGate(){
		this.getWorld().dropElement(this.getWorld().getLorann().getX(), this.getWorld().getLorann().getY());
		this.getWorld().searchGate() ;
	}
	
	private void resolveEndLevel(){
		this.getWorld().endLevel();
	}
		
/*	private void afficherWorld(){
		for (int y=0 ; y<12 ; y++){
			for (int x=0 ; x<20 ; x++){
				System.out.print(this.getWorld().getElementXY(x, y).getSprite()) ;
			}
			System.out.println() ;
		}
		System.out.println(this.getWorld().getElementXY(2, 3).getSprite().getTest());
	}*/
}
