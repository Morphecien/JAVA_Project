package elementsMobile;

import contract.Movement;

public class IA_ChoosePlayerDirection extends Behaviors{	
	public IA_ChoosePlayerDirection(MobileAuto mobile){
		super(mobile) ;
	}

	public void autoMovement(){
		Movement lastDirection = this.getMobile().getDirection();
		final int xLorann = this.getWorld().getLorann().getX();
		final int yLorann = this.getWorld().getLorann().getY();
		final int xMagicBall = this.getMobile().getX();
		final int yMagicBall = this.getMobile().getY();
		final int xGap = Math.abs(xMagicBall - xLorann);
		final int yGap = Math.abs(yMagicBall - yLorann);
		
		if (yLorann < yMagicBall){			// UP
			if (xLorann < xMagicBall){			// LEFT
				if (xGap > yGap*2){					// Choose LEFT
					this.getMobile().setDirection(Movement.LEFT) ;
				}
				else if (yGap > xGap*2){			// Choose UP
					this.getMobile().setDirection(Movement.UP) ;
				}
				else{								// Choose UP_LEFT
					this.getMobile().setDirection(Movement.UP_LEFT) ;
				}
			}
			else if (xLorann > xMagicBall){		// RIGHT
				if (xGap > yGap*2){					// Choose RIGHT
					this.getMobile().setDirection(Movement.RIGHT) ;
				}
				else if (yGap > xGap*2){			// Choose UP
					this.getMobile().setDirection(Movement.UP) ;
				}
				else{								// Choose UP_RIGHT
					this.getMobile().setDirection(Movement.UP_RIGHT) ;
				}
			}
			else{								// X don't change
				this.getMobile().setDirection(Movement.UP) ;
			}
		}
		else if (yLorann > yMagicBall){		// DOWN
			if (xLorann < xMagicBall){			// LEFT
				if (xGap > yGap*2){					// Choose LEFT
					this.getMobile().setDirection(Movement.LEFT) ;
				}
				else if (yGap > xGap*2){			// Choose DOWN
					this.getMobile().setDirection(Movement.DOWN) ;
				}
				else{								// Choose DOWN_LEFT
					this.getMobile().setDirection(Movement.DOWN_LEFT) ;
				}
			}
			else if (xLorann > xMagicBall){		// RIGHT
				if (xGap > yGap*2){					// Choose RIGHT
					this.getMobile().setDirection(Movement.RIGHT) ;
				}
				else if (yGap > xGap*2){			// Choose DOWN
					this.getMobile().setDirection(Movement.DOWN) ;
				}
				else{								// Choose DOWN_RIGHT
					this.getMobile().setDirection(Movement.DOWN_RIGHT) ;
				}
			}
			else{								// X don't change
				this.getMobile().setDirection(Movement.DOWN) ;
			}
		}
		else {								// Y don't change
			if (xLorann < xMagicBall){			// LEFT
				this.getMobile().setDirection(Movement.LEFT) ;
			}
			else if (xLorann > xMagicBall){		// RIGHT
				this.getMobile().setDirection(Movement.RIGHT) ;
			}
			else{								// X don't change
				this.getMobile().setDirection(Movement.NOPE) ;
			}
		}
		this.movement();
		if (this.getMobile().isEndMove() == false){
			this.inverseDirection(this.getMobile().getDirection());
			this.movement();
			if (this.getMobile().isEndMove() == false){
				this.getMobile().setDirection(lastDirection);
				this.movement();
			}
		}
	}
}
