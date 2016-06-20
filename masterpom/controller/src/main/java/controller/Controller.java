package controller;

import contract.IController;
import contract.IModel;
import contract.IView;
import contract.Movement;

public class Controller implements IController, Runnable {

	private IView		view;

	private IModel	model;

	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
		this.run() ;
	}

	public void control() {
	//	this.view.printMessage("yo");
	}

	private void setView(final IView view) {
		this.view = view;
	}

	private void setModel(final IModel model) {
		this.model = model;
	}
	
	public void run(){
		
	}

	public void movementLorann(final Movement movementOrder) {
		switch (movementOrder) {
			case UP:
				this.model.LorannMoveUP();				break;
			case UP_LEFT:
				this.model.LorannMoveUP_LEFT();			break;
			case LEFT:
				this.model.LorannMoveLEFT();			break;
			case DOWN_LEFT:
				this.model.LorannMoveDOWN_LEFT();		break;
			case DOWN:
				this.model.LorannMoveDOWN();			break;
			case DOWN_RIGHT:
				this.model.LorannMoveDOWN_RIGHT();		break;
			case RIGHT:
				this.model.LorannMoveRIGHT();			break;
			case UP_RIGHT:
				this.model.LorannMoveUP_RIGHT();		break;
			case SPACE:
				this.model.LorannMagicBall() ;			break;
			default:									break;
		}
		model.getWorldAnswer();
	}

}
