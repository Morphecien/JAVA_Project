package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.IController;
import contract.IModel;
import contract.IView;
import contract.MovementLorann;

public class View implements IView, Runnable {

	private final ViewFrame viewFrame;

	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	protected static MovementLorann keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_UP:
				return MovementLorann.UP;
			case KeyEvent.VK_DOWN:
				return MovementLorann.DOWN;
			case KeyEvent.VK_LEFT:
				return MovementLorann.LEFT;
			case KeyEvent.VK_RIGHT:
				return MovementLorann.RIGHT;
			default:
				return MovementLorann.NOPE;
		}
	}

	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	public void run() {
		this.viewFrame.setVisible(true);
	}

	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}
