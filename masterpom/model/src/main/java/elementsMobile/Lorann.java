package elementsMobile;

import java.util.ArrayList;

import contract.Movement;
import elementsAll.Sprite;

public class Lorann extends MobileElement {
	private int score ;
	private int life ;
	private MagicBall magicBall;
	private Movement lastMoov ;
	private final ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	private final String spriteSymbol = "X" ;
	private int spriteNumber ;
	
	public Lorann() {
		super(new Sprite("@", "lorann_ur.png"), "Player");
		this.prepareSprites();
		this.score = 0 ;
		this.life = 11 ;
		this.magicBall = new MagicBall() ;
		this.lastMoov = Movement.NOPE ;
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
		this.setSprite(this.getSprites().get(getSpriteNumber()));
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
	public void moveUp() {
		this.setLastMoov(Movement.UP);
		super.moveUp();
		this.changeSprite(7);
		this.isMobileDie(0, -1) ;
	}
	
	@Override
	public void moveUpLeft() {
		this.setLastMoov(Movement.UP_LEFT);
		super.moveUpLeft();
		this.changeSprite(6);
		this.isMobileDie(-1, -1) ;
	}

	@Override
	public void moveLeft() {
		this.setLastMoov(Movement.LEFT);
		super.moveLeft();
		this.changeSprite(5);
		this.isMobileDie(-1, 0) ;
	}
	
	@Override
	public void moveDownLeft() {
		this.setLastMoov(Movement.DOWN_LEFT);
		super.moveDownLeft();
		this.changeSprite(4);
		this.isMobileDie(-1, 1) ;
	}

	@Override
	public void moveDown() {
		this.setLastMoov(Movement.DOWN);
		super.moveDown();
		this.changeSprite(3);
		this.isMobileDie(0, 1) ;
	}
	
	@Override
	public void moveDownRight() {
		this.setLastMoov(Movement.DOWN_RIGHT);
		super.moveDownRight();
		this.changeSprite(2);
		this.isMobileDie(1, 1) ;
	}

	@Override
	public void moveRight() {
		this.setLastMoov(Movement.RIGHT);
		super.moveRight();
		this.changeSprite(1);
		this.isMobileDie(1, 0) ;
	}
	
	@Override
	public void moveUpRight() {
		this.setLastMoov(Movement.UP_RIGHT);
		super.moveUpRight();
		this.changeSprite(0);
		this.isMobileDie(1, -1) ;
	}
	
	public void shootBall(){
		if (this.getMagicBall().isActive() == false){
			this.getWorld().addMobile(this.getMagicBall(), this.getX(), this.getY());
			this.getMagicBall().activate(this.getLastMoov()) ;
		}
		else{
	//		this.getMagicBall().autoMovement();
			this.getMagicBall().chooseDirection();
			this.getMagicBall().autoMovement();
		}
	}

	public MagicBall getMagicBall() {
		return this.magicBall;
	}
	
	@Override
	protected void isMobileDie(final int xDirection, final int yDirection) {			// Lorann Die and Pick up Magic Ball
		int size = this.getWorld().getMobiles().size() ;
		if (this.isEndMove() == false){
			for (int k = 0 ; k < size ; k++){
				MobileElement mobile = this.getWorld().getMobiles().get(k) ;
				if (((mobile.getX() == (this.getX() + xDirection)) && (mobile.getY() == (this.getY() + yDirection))) && (mobile.getFileSymbol() != "Magicball")){
					System.out.println("Lorann was died by " + mobile.getFileSymbol());
				}
			}
		}
		else{
			for (int k = 0 ; k < size ; k++){
				MobileElement mobile = this.getWorld().getMobiles().get(k) ;
				if (((mobile.getX() == (this.getX())) && (mobile.getY() == (this.getY()))) && (mobile.getFileSymbol() == "Magicball")){
					System.out.println("Lorann pick up the Magic Ball : " + mobile.getFileSymbol());
					this.getMagicBall().reinitialize() ;
				}
			}
		}
	}

	@Override
	protected void isMobileKill(int xDirection, int yDirection) {
		// Not implemented : Lorann not kill
	}
}
