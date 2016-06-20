package elementsMobile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import contract.Movement;
import elementsAll.Permeability;
import elementsAll.Sprite;
import elementsMotionless.MotionlessDetermineElement;
import elementsMotionless.MotionlessElement;

public class Lorann extends MobileElement implements Runnable, ActionListener{
	private int score ;
	private int life ;
	private MagicBall magicBall;
	private Movement lastMoov ;
	private final ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	private final String spriteSymbol = "@" ;
	private int spriteNumber ;
	
	public Lorann() {
		super(new Sprite("@", "lorann_ur.png"), "Player");
		this.prepareSprites();
		this.score = 0 ;
		this.life = 11 ;
		this.magicBall = new MagicBall() ;
		this.lastMoov = Movement.NOPE ;
		setMoveTimer(new Timer(150, this));
		this.run() ;
	}
	
	public void actionPerformed(ActionEvent e) {
		this.changeSprite() ;
		this.getWorld().worldHasChanged();
		
	}

	public void run() {
		this.getMoveTimer().setInitialDelay(500);
		this.getMoveTimer().start();
	}
	
	private void prepareSprites(){
		this.getSprites().add(new Sprite(this.getSpriteSymbol(), "lorann_ur.png")) ;	// 0
		this.getSprites().add(new Sprite(this.getSpriteSymbol(), "lorann_r.png")) ;		// 1
		this.getSprites().add(new Sprite(this.getSpriteSymbol(), "lorann_br.png")) ;	// 2
		this.getSprites().add(new Sprite(this.getSpriteSymbol(), "lorann_b.png")) ;		// 3
		this.getSprites().add(new Sprite(this.getSpriteSymbol(), "lorann_bl.png")) ;	// 4
		this.getSprites().add(new Sprite(this.getSpriteSymbol(), "lorann_l.png")) ;		// 5
		this.getSprites().add(new Sprite(this.getSpriteSymbol(), "lorann_ul.png")) ;	// 6
		this.getSprites().add(new Sprite(this.getSpriteSymbol(), "lorann_u.png")) ;		// 7
	}
	
	private void changeSprite(){
		int newSprite = this.getSpriteNumber()+1 ;
		int size = this.getSprites().size() ;
		if (newSprite < size){
			this.setSpriteNumber(this.getSpriteNumber()+1) ;
		}
		else{
			this.setSpriteNumber(0) ;
		}
		this.setSprite(this.getSprites().get(this.getSpriteNumber()));
	}
	
	private void changeSprite(final int idSprite){
		this.setSpriteNumber(idSprite) ;
		this.setSprite(this.getSprites().get(getSpriteNumber()));
	}
	
	public ArrayList<Sprite> getSprites() {
		return sprites;
	}
	
	public String getSpriteSymbol() {
		return spriteSymbol;
	}
	
	public int getSpriteNumber() {
		return spriteNumber;
	}

	public void setSpriteNumber(int spriteNumber) {
		this.spriteNumber = spriteNumber;
	}
	
	public Movement getLastMoov() {
		return lastMoov;
	}

	public void setLastMoov(Movement lastMoov) {
		this.lastMoov = lastMoov;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
	@Override
	protected void movePossible(final int x, final int y){
		if ((((x>=0) && (x < this.getWorld().getWidth())) && ((y>=0) && (y < this.getWorld().getHeight()))) && (this.isActive())){
			Permeability permeabilityMotionless = this.getWorld().getElementXY(x, y).getPermeabilityLorann() ;
			Permeability permeabilityMobile = Permeability.PENETRABLE;
			int size = this.getWorld().getMobiles().size() ;
			int i = 0 ;
			int j = 0 ;
			for (int k = 0 ; k < size ; k++){
				MobileElement mobile2 = this.getWorld().getMobiles().get(k) ;
				i = mobile2.getX() ;
				j = mobile2.getY() ;
				if ((i == x) && (j == y)){
					permeabilityMobile = mobile2.getPermeabilityLorann() ;
				}
			}
	//		System.out.println(this.getFileSymbol() + " : " + permeabilityMotionless + " | " + permeabilityMobile);
			if ((permeabilityMotionless != Permeability.BLOCKING) && (permeabilityMobile != Permeability.BLOCKING)){
				setEndMove(true) ;
			}
			else{
				setEndMove(false) ;
			}
		}
		else{
			setEndMove(false) ;
		}
	}
	
	@Override
	public void moveUp() {
		this.setLastMoov(Movement.UP);
		super.moveUp();
		this.changeSprite(7);
		this.getMoveTimer().restart();
		this.isMobileAction(0, -1) ;
	}
	
	@Override
	public void moveUpLeft() {
		this.setLastMoov(Movement.UP_LEFT);
		super.moveUpLeft();
		this.changeSprite(6);
		this.getMoveTimer().restart();
		this.isMobileAction(-1, -1) ;
	}

	@Override
	public void moveLeft() {
		this.setLastMoov(Movement.LEFT);
		super.moveLeft();
		this.changeSprite(5);
		this.getMoveTimer().restart();
		this.isMobileAction(-1, 0) ;
	}
	
	@Override
	public void moveDownLeft() {
		this.setLastMoov(Movement.DOWN_LEFT);
		super.moveDownLeft();
		this.changeSprite(4);
		this.getMoveTimer().restart();
		this.isMobileAction(-1, 1) ;
	}

	@Override
	public void moveDown() {
		this.setLastMoov(Movement.DOWN);
		super.moveDown();
		this.changeSprite(3);
		this.getMoveTimer().restart();
		this.isMobileAction(0, 1) ;
	}
	
	@Override
	public void moveDownRight() {
		this.setLastMoov(Movement.DOWN_RIGHT);
		super.moveDownRight();
		this.changeSprite(2);
		this.getMoveTimer().restart();
		this.isMobileAction(1, 1) ;
	}

	@Override
	public void moveRight() {
		this.setLastMoov(Movement.RIGHT);
		super.moveRight();
		this.changeSprite(1);
		this.getMoveTimer().restart();
		this.isMobileAction(1, 0) ;
	}
	
	@Override
	public void moveUpRight() {
		this.setLastMoov(Movement.UP_RIGHT);
		super.moveUpRight();
		this.changeSprite(0);
		this.getMoveTimer().restart();
		this.isMobileAction(1, -1) ;
	}
	
	public void shootBall(){
		if (this.getMagicBall().isActive() == false){
			boolean possible = false ;
			switch(this.getLastMoov()){
				case UP : 			if (this.getWorld().getElementXY(this.getX(), this.getY() +1) == (MotionlessElement) MotionlessDetermineElement.NOTHING){ possible = true ;} break ;
				case UP_LEFT : 		if (this.getWorld().getElementXY(this.getX()+1, this.getY() +1) == (MotionlessElement) MotionlessDetermineElement.NOTHING){ possible = true ;} break ;
				case LEFT : 		if (this.getWorld().getElementXY(this.getX()+1, this.getY()) == (MotionlessElement) MotionlessDetermineElement.NOTHING){ possible = true ;} break ;
				case DOWN_LEFT : 	if (this.getWorld().getElementXY(this.getX()+1, this.getY() -1) == (MotionlessElement) MotionlessDetermineElement.NOTHING){ possible = true ;} break ;
				case DOWN : 		if (this.getWorld().getElementXY(this.getX(), this.getY() -1) == (MotionlessElement) MotionlessDetermineElement.NOTHING){ possible = true ;} break ;
				case DOWN_RIGHT : 	if (this.getWorld().getElementXY(this.getX()-1, this.getY() -1) == (MotionlessElement) MotionlessDetermineElement.NOTHING){ possible = true ;} break ;
				case RIGHT : 		if (this.getWorld().getElementXY(this.getX()-1, this.getY()) == (MotionlessElement) MotionlessDetermineElement.NOTHING){ possible = true ;} break ;
				case UP_RIGHT : 	if (this.getWorld().getElementXY(this.getX()-1, this.getY() +1) == (MotionlessElement) MotionlessDetermineElement.NOTHING){ possible = true ;} break ;
				case NOPE : 	//	System.out.println("C'est bien dommage d'en arriver là : NOPE (Le mobile " + this.getFileSymbol() + " ne connait pas sa direction de déplacement)");
									break ;
				default : 					break ;
			}
			if (possible){
				this.getWorld().addMobile(this.getMagicBall(), this.getX(), this.getY());
				this.getMagicBall().activate(this.getLastMoov()) ;
			}
		}
		else{
			this.getMagicBall().choosePlayerDirection();
		}
	}

	public MagicBall getMagicBall() {
		return this.magicBall;
	}
	
	@Override
	protected void isMobileAction(final int xDirection, final int yDirection) {			// Lorann Die and Pick up Magic Ball
		if ((((this.getX() + xDirection)>=0) && ((this.getX() + xDirection) < this.getWorld().getWidth())) && (((this.getY() + yDirection)>=0) && ((this.getY() + yDirection) < this.getWorld().getHeight()))){
			int size = this.getWorld().getMobiles().size() ;
			if ((this.isEndMove() == false) && (this.isActive() == true)){
				boolean lorannDie = false ;
				for (int k = 0 ; k < size ; k++){
					MobileElement mobile = this.getWorld().getMobiles().get(k) ;
					if (((mobile.getX() == (this.getX() + xDirection)) && (mobile.getY() == (this.getY() + yDirection))) && (mobile.getFileSymbol() != "Magicball")){
						System.out.println("Lorann was died by " + mobile.getFileSymbol());
						lorannDie = true ;
					}
				}
			//	System.out.println("x : " + );
				if (lorannDie){this.getWorld().lorannDie();}
				else if (this.getWorld().getElementXY(this.getX() + xDirection, this.getY() + yDirection).getElementActionOnHeroes() == MotionlessDetermineElement.GRAVE.getElementActionOnHeroes()){
					System.out.println("Lorann was died by a " + this.getWorld().getElementXY(this.getX() + xDirection, this.getY() + yDirection).getFileSymbol());
					this.getWorld().lorannDie() ;
				}
				else if (this.getWorld().getElementXY(this.getX() + xDirection, this.getY() + yDirection).getElementActionOnHeroes() == MotionlessDetermineElement.BLOC.getElementActionOnHeroes()){
					System.out.println("Lorann push a " + this.getWorld().getElementXY(this.getX() + xDirection, this.getY() + yDirection).getFileSymbol());
					this.pushBloc(xDirection, yDirection);
				}
			}
			else if (this.isActive()){
				for (int k = 0 ; k < size ; k++){
					MobileElement mobile = this.getWorld().getMobiles().get(k) ;
					if (((mobile.getX() == (this.getX())) && (mobile.getY() == (this.getY()))) && (mobile.getFileSymbol() == "Magicball")){
						System.out.println("Lorann pick up the Magic Ball : " + mobile.getFileSymbol());
						this.getMagicBall().reinitialize() ;
					}
				}
			}
		}
	}
	
	private void pushBloc(final int xDirection, final int yDirection){
		if (this.getWorld().getElementXY(this.getX() + 2*xDirection, this.getY() + 2*yDirection).getFileSymbol() == MotionlessDetermineElement.NOTHING.getFileSymbol()){
			int size = this.getWorld().getMobiles().size() ;
			boolean moveBloc = true;
			for (int k = 0 ; k < size ; k++){
				MobileElement mobile = this.getWorld().getMobiles().get(k) ;
				if (((mobile.getX() == (this.getX() + xDirection)) && (mobile.getY() == (this.getY() + yDirection))) && (mobile.getFileSymbol() != "Magicball")){
					moveBloc = false;
				}	
			}
			if (moveBloc){
				this.getWorld().dropElement(MotionlessDetermineElement.NOTHING, this.getX() + xDirection, getY() + yDirection);
				this.getWorld().dropElement(MotionlessDetermineElement.BLOC, this.getX() + 2*xDirection, getY() + 2*yDirection);
			}
		}
		else{
			System.out.printf("Impossible de déplacer le bloc !") ;
		}
	}
}
