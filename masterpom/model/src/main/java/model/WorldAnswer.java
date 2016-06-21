package model;

import elementsMotionless.*;

/**
 * The class WorldAnswer
 * 
 * @author Samuel DUCANGE
 *
 */
public class WorldAnswer {
	private Iworld world ;
	
	/**
	 * Constructor of WorldAnswer
	 * @param world
	 * 			the world
	 */
	public WorldAnswer(World world){
		this.world = world ;
	}
	
	/**
	 * Get the world
	 * @return world
	 */
	public Iworld getWorld(){
		return this.world ;
	}
	
	/**
	 * Get the answer of the world
	 */
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
			default:
				break;
		}
		this.getWorld().worldHasChanged() ;
	}
	
	/**
	 * Method execute when the sprite is a treasure
	 * @param element
	 * 			the element
	 */
	private void resolveCollectTreasure(Itreasures element){
		System.out.print("score : " + this.getWorld().getLorann().getScore() + " | new ");
		final int score = this.getWorld().getLorann().getScore() + element.collectTreasure() ;
		this.getWorld().getLorann().setScore(score) ;
		System.out.println("Score : " + this.getWorld().getLorann().getScore());
		this.getWorld().dropElement(this.getWorld().getLorann().getX(), this.getWorld().getLorann().getY());
	}
	
	/**
	 * Method execute when Lorann pick up the idol
	 */
	private void resolveObtainNewLife(){
		System.out.print("Lifes : " + this.getWorld().getLorann().getLife() + " | new ");
		final int life = this.getWorld().getLorann().getLife() + 1 ;
		this.getWorld().getLorann().setLife(life) ;
		System.out.println("Lifes : " + this.getWorld().getLorann().getLife());
		this.getWorld().dropElement(this.getWorld().getLorann().getX(), this.getWorld().getLorann().getY());
	}
	
	/**
	 * Method which unlock the gate and drop the blocs when Lorann pick up the Crystal-ball
	 */
	private void resolveUnlocksGate(){
		this.getWorld().dropElement(this.getWorld().getLorann().getX(), this.getWorld().getLorann().getY());
		this.getWorld().searchGate() ;
	}
	
	/**
	 * Method execute when Lorann is on the Gate-open, switch level
	 */
	private void resolveEndLevel(){
		this.getWorld().endLevel();
	}
}
