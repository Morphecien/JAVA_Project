package elementsMobile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import behaviors.IBehavior;
import contract.Movement;
import elementsAll.ISprite;
import elementsAll.Permeability;

public abstract class MobileAuto extends MobileElement implements Runnable, ActionListener{
	private Movement direction ;
	private IBehavior IA_behavior ;

	public MobileAuto(ISprite sprite, Permeability permea, String fileSymbol) {
		super(sprite, permea, fileSymbol);
		setMoveTimer(new Timer(150, this));
		run();
	}

	public MobileAuto(ISprite sprite, String fileSymbol) {
		super(sprite, fileSymbol);
		setMoveTimer(new Timer(150, this));
		run();
	}
	public MobileAuto(ISprite sprite, String fileSymbol, final int delay) {
		super(sprite, fileSymbol);
		setMoveTimer(new Timer(delay, this));
		run();
	}
	
	public abstract void initIA() ;

	public IBehavior getIA_behavior() {
		this.IA_behavior.setMobile(this) ;
		return IA_behavior;
	}

	public void setIA_behavior(IBehavior IA_behavior) {
		this.IA_behavior = IA_behavior;
	}
	
	public Movement getDirection() {
		return direction;
	}

	public void setDirection(Movement direction) {
		this.direction = direction;
	}
	
	@Override
	protected void movePossible(final int x, final int y){
		if (((x>=0) && (x < this.getWorld().getWidth())) && ((y>=0) && (y < this.getWorld().getHeight()))){
			Permeability permeabilityMotionless = this.getWorld().getElementXY(x, y).getPermeabilityOther() ;
			Permeability permeabilityMobile = Permeability.PENETRABLE;
			int size = this.getWorld().getMobiles().size() ;
			int i = 0 ;
			int j = 0 ;
			for (int k = 0 ; k < size ; k++){
				MobileElement mobile2 = this.getWorld().getMobiles().get(k) ;
				i = mobile2.getX() ;
				j = mobile2.getY() ;
				if ((i == x) && (j == y)){
					permeabilityMobile = mobile2.getPermeabilityOther() ;
				}
			}
		//	System.out.println(this.getFileSymbol() + " : " + permeabilityMotionless + " | " + permeabilityMobile);
			if ((permeabilityMotionless != Permeability.BLOCKING) && (permeabilityMobile != Permeability.BLOCKING)){
				setEndMove(TypeEndMove.TRUE) ;
			}
			else{
				setEndMove(TypeEndMove.BLOCKING) ;
			}
		}
		else{
			setEndMove(TypeEndMove.BLOCKING) ;
		}
	}
	
	public void movement(){
		switch(this.getDirection()){
			case UP : 			super.moveUp();
								this.isMobileAction(0, -1) ;
										break ;
			case UP_LEFT : 		super.moveUpLeft();
								this.isMobileAction(-1, -1) ;
										break ;
			case LEFT : 		super.moveLeft();
								this.isMobileAction(-1, 0) ;
										break ;
			case DOWN_LEFT : 	super.moveDownLeft();
								this.isMobileAction(-1, 1) ;
										break ;
			case DOWN : 		super.moveDown();
								this.isMobileAction(0, 1) ;
										break ;
			case DOWN_RIGHT : 	super.moveDownRight();
								this.isMobileAction(1, 1) ;
										break ;
			case RIGHT : 		super.moveRight();
								this.isMobileAction(1, 0) ;
										break ;
			case UP_RIGHT : 	super.moveUpRight();
								this.isMobileAction(1, -1) ;
										break ;
			case NOPE : 	//	System.out.println("C'est bien dommage d'en arriver là : NOPE (Le mobile " + this.getFileSymbol() + " ne connait pas sa direction de déplacement)");
										break ;
			default : 					break ;
		}
	}
	
	public void activate(Movement direction){
		this.setActive(true);
		this.autoMovement();
	}
	
	protected void initialize(){
		this.setActive(false);
		this.setDirection(Movement.NOPE) ;
	}

	public void reinitialize(){
		this.getMoveTimer().stop();
		this.initialize();
		this.deleteObject();
	}
	
	private void deleteInArrayList(MobileElement element){
		final int size = this.getWorld().getMobiles().size() ;
		int kMobile = -1 ;
		for (int k = 0 ; k < size ; k++){
			MobileElement mobile = this.getWorld().getMobiles().get(k) ;
			if (mobile == element){
				kMobile = k ;
			}
		}
		if (kMobile != -1){
			this.getWorld().delMobile(kMobile);
		}
	}
	
	protected void deleteObject(){
		deleteInArrayList(this) ;
	}
	
	protected void deleteObject(MobileElement element){
		deleteInArrayList(element) ;
	}

	public abstract void autoMovement() ;

	public void run() 
	{
		this.getMoveTimer().start();
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (this.isActive()){
			this.autoMovement();
	//		System.out.println("File symbol : " + this.getFileSymbol());
			this.getWorld().worldHasChanged();
		}
	}
	

}
