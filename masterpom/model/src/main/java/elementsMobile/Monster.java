package elementsMobile;

import elementsAll.ISprite;

public abstract class Monster extends MobileAuto {
	public Monster(ISprite sprite, final String monsterSymbol, final int delayAction) {
		super(sprite, monsterSymbol, delayAction);
		this.initialize();
	}
	
	@Override
	public void isMobileAction(int xDirection, int yDirection) {
		if (this.getEndMove() == TypeEndMove.BLOCKING){
			final int size = this.getWorld().getMobiles().size() ;
			int indexKillPlayer = -1 ;
			int indexKillByMagicBall = -1 ;
			for (int k = 0 ; k < size ; k++){
				MobileElement mobile = this.getWorld().getMobiles().get(k) ;
				if ((mobile.getX() == (this.getX() + xDirection)) && (mobile.getY() == (this.getY() + yDirection))){
					if (mobile.getFileSymbol() == "Player"){				// Kill Lorann
						indexKillPlayer = k ;
					}
					else if (mobile.getFileSymbol() == "Magicball"){		// Kill Monster
						indexKillByMagicBall = k ;
					}
				}
			}
			if (indexKillPlayer !=-1){
				MobileElement mobile = this.getWorld().getMobiles().get(indexKillPlayer) ;					// Kill Lorann
				System.out.println("A mobile was killed (Monster event) : " + mobile.getFileSymbol());
				this.getWorld().lorannDie();
			}
			else if (indexKillByMagicBall != -1){
				int indexThisMobile = -1 ;
				for (int k = 0 ; k < size ; k++){
					MobileElement mobile = this.getWorld().getMobiles().get(k) ;
					if (mobile.getFileSymbol() == this.getFileSymbol()){				// Kill Monster and Magic Ball
						indexThisMobile = k ;
					}
				}
				if (indexThisMobile !=-1){
					MobileElement mobile = this.getWorld().getMobiles().get(indexThisMobile) ;
					System.out.println("A mobile was killed (Monster event) : " + mobile.getFileSymbol());
					this.getWorld().delMobile(indexThisMobile);
					this.getWorld().getLorann().getMagicBall().reinitialize();
				}
			}
		}
	}
}
