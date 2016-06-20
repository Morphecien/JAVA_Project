package elementsMobile;

import java.util.ArrayList;

import contract.Movement;
import elementsAll.Permeability;
import elementsAll.Sprite;

public class MagicBall extends MobileAuto{
	private final ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	private final String spriteSymbol = "X" ;
	private int spriteNumber ;

	public MagicBall() {
		super(new Sprite("X", "fireball_5.png"), Permeability.PENETRABLE, "Magicball");
		prepareSprites() ;
		this.initialize() ;
		
	}
	
	private void prepareSprites(){
		this.getSprites().add(new Sprite(this.getSpriteSymbol(), "fireball_1.png")) ;
		this.getSprites().add(new Sprite(this.getSpriteSymbol(), "fireball_2.png")) ;
		this.getSprites().add(new Sprite(this.getSpriteSymbol(), "fireball_3.png")) ;
		this.getSprites().add(new Sprite(this.getSpriteSymbol(), "fireball_4.png")) ;
		this.getSprites().add(new Sprite(this.getSpriteSymbol(), "fireball_5.png")) ;
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

	@Override
	public void movement(){
		super.movement() ;
		this.changeSprite();
	}
	
	public void chooseDirection(){
		final int xLorann = this.getWorld().getLorann().getX();
		final int yLorann = this.getWorld().getLorann().getY();
		final int xMagicBall = this.getX();
		final int yMagicBall = this.getY();
		final int xGap = Math.abs(xMagicBall - xLorann);
		final int yGap = Math.abs(yMagicBall - yLorann);
		
		if (yLorann < yMagicBall){			// UP
			if (xLorann < xMagicBall){			// LEFT
				if (xGap > yGap*2){					// Choose LEFT
					this.setDirection(Movement.LEFT) ;
				}
				else if (yGap > xGap*2){			// Choose UP
					this.setDirection(Movement.UP) ;
				}
				else{								// Choose UP_LEFT
					this.setDirection(Movement.UP_LEFT) ;
				}
			}
			else if (xLorann > xMagicBall){		// RIGHT
				if (xGap > yGap*2){					// Choose RIGHT
					this.setDirection(Movement.RIGHT) ;
				}
				else if (yGap > xGap*2){			// Choose UP
					this.setDirection(Movement.UP) ;
				}
				else{								// Choose UP_RIGHT
					this.setDirection(Movement.UP_RIGHT) ;
				}
			}
			else{								// X don't change
				this.setDirection(Movement.UP) ;
			}
		}
		else if (yLorann > yMagicBall){		// DOWN
			if (xLorann < xMagicBall){			// LEFT
				if (xGap > yGap*2){					// Choose LEFT
					this.setDirection(Movement.LEFT) ;
				}
				else if (yGap > xGap*2){			// Choose DOWN
					this.setDirection(Movement.DOWN) ;
				}
				else{								// Choose DOWN_LEFT
					this.setDirection(Movement.DOWN_LEFT) ;
				}
			}
			else if (xLorann > xMagicBall){		// RIGHT
				if (xGap > yGap*2){					// Choose RIGHT
					this.setDirection(Movement.RIGHT) ;
				}
				else if (yGap > xGap*2){			// Choose DOWN
					this.setDirection(Movement.DOWN) ;
				}
				else{								// Choose DOWN_RIGHT
					this.setDirection(Movement.DOWN_RIGHT) ;
				}
			}
			else{								// X don't change
				this.setDirection(Movement.DOWN) ;
			}
		}
		else {								// Y don't change
			if (xLorann < xMagicBall){			// LEFT
				this.setDirection(Movement.LEFT) ;
			}
			else if (xLorann > xMagicBall){		// RIGHT
				this.setDirection(Movement.RIGHT) ;
			}
			else{								// X don't change
				this.setDirection(Movement.NOPE) ;
				System.out.println("C'est pas normal : NOPE sur le choose direction (Magic Ball) de Lorann");
			}
		}
	}

	@Override
	public synchronized void autoMovement() {
		this.movement();
	}
	
	@Override
	public void activate(Movement direction){
		this.inverseDirection(direction);
		super.activate(direction);
	}
	
	@Override
	protected void initialize(){
		super.initialize() ;
		this.setSpriteNumber(this.getSprites().size());
	}
	
	@Override
	public void reinitialize(){
		this.initialize();
		this.deleteObject();
	}

	@Override
	protected void isMobileAction(int xDirection, int yDirection) {	// Monsters die
		if (this.isEndMove() == false){
			final int size = this.getWorld().getMobiles().size() ;
			int indexKill = -1 ;
			int indexPickUpPlayer = -1 ;
			for (int k = 0 ; k < size ; k++){
				MobileElement mobile = this.getWorld().getMobiles().get(k) ;
				if ((mobile.getX() == (this.getX() + xDirection)) && (mobile.getY() == (this.getY() + yDirection))){
					if (mobile.getFileSymbol() != "Player"){		// Kill Monster
						indexKill = k ;
					}
					else{
						indexPickUpPlayer = k;						// Pick up by Lorann
					}
				}
			}
			if (indexKill !=-1){
				MobileElement mobile = this.getWorld().getMobiles().get(indexKill) ;					// Kill Monster
				System.out.println("A mobile was died : " + mobile.getFileSymbol());
				this.deleteObject(mobile);
				this.reinitialize() ;
			}
			else if (indexPickUpPlayer != -1){
				MobileElement mobile = this.getWorld().getMobiles().get(indexPickUpPlayer) ;			// Pick up by Lorann
				System.out.println("The Magic-ball was pick-up by Lorann : " + mobile.getFileSymbol());
				this.reinitialize() ;
			}
			else{
				this.inverseDirection(this.getDirection());
				int getSprite = this.getSpriteNumber() ;
				this.autoMovement();
				this.setSpriteNumber(getSprite) ;
			}
		}
	}
}
