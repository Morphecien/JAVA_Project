package behaviors;

import elementsMotionless.MotionlessDetermineElement;

public class IA_ChoosePlayerDirection_IfViewPlayer extends Behaviors{

	public IA_ChoosePlayerDirection_IfViewPlayer(){
		super() ;
	}

	public void autoMovement() {
		final int xLorann = this.getMobile().getWorld().getLorann().getX();
		final int yLorann = this.getMobile().getWorld().getLorann().getY();
		final int xMobile = this.getMobile().getX();
		final int yMobile = this.getMobile().getY();
		final int xGap = Math.abs(xMobile - xLorann);
		final int yGap = Math.abs(yMobile - yLorann);
		double y = 1 ;
		double x = 1 ;
		int yFloor = 1 ;
		int yCeil = 0 ;
		int xFloor = 1 ;
		int xCeil = 0 ;
		System.out.println("donc, récapitulons : xGap = " + xGap + "   yGap = " + yGap + "   x = " + x + "   y = " + y);
		while ((y< yGap) || (x < xGap)){
			if (yGap != 0){
				x += 1 + (xGap/yGap) ;
			}
			else{
				x++ ;
				y = 1 ;
			}
			if (xGap != 0){
				y += (yGap/xGap) ;
			}
			yCeil = (int) Math.ceil(y) ;
			xCeil = (int) Math.ceil(x) ;
			System.out.println("Alors, on est rentré : xCeil = " + xCeil + "   yCeil = " + yCeil + "   xFloor = " + xFloor + "   yFloor = " + yFloor);
			System.out.println("donc, récapitulons : xGap = " + xGap + "   yGap = " + yGap + "   x = " + x + "   y = " + y);
			for (int i = yFloor ; i<yCeil ; i++){
				for (int j = xFloor ; j<=xCeil ; j++){
					if (this.getMobile().getWorld().getElementXY(j, i) != MotionlessDetermineElement.NOTHING){
						System.out.println("C'est mort, il m'a pas trouvé !");
					}
					else{
						System.out.println("Bon, pour le moement ça passe");
					}
				}
			}
			yFloor = (int) Math.floor(y) ;
			xFloor = (int) Math.floor(x) ;
		}
		System.out.println("Alors, ça disait quoi ?");
	}
}
