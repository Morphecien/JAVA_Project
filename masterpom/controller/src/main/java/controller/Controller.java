package controller;

import contract.IController;
import contract.IModel;
import contract.IView;
import contract.MovementLorann;

public class Controller implements IController {

	private IView		view;

	private IModel	model;

	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	public void control() {
	//	this.view.printMessage("Appuyer sur les touches 'E', 'F', 'D' ou 'I', pour afficher Hello world dans la langue d votre choix.");
	}

	private void setView(final IView view) {
		this.view = view;
	}

	private void setModel(final IModel model) {
		this.model = model;
	}

	public void movementLorann(final MovementLorann controllerOrder) {
		switch (controllerOrder) {
			case UP:
				this.model.LorannMoveUP();
				break;
			case DOWN:
				this.model.LorannMoveDOWN();
				break;
			case LEFT:
				this.model.LorannMoveLEFT();
				break;
			case RIGHT:
				this.model.LorannMoveRIGHT();
				break;

			default:
				break;
		}
		model.getWorldAnswer();
	}

}
