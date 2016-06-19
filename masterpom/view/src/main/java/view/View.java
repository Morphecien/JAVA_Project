package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.IController;
import contract.IModel;
import contract.IView;
import contract.Movement;

public class View implements IView, Runnable {

	private final ViewFrame viewFrame;

	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	protected static Movement keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_UP:
				return Movement.UP;
			case KeyEvent.VK_DOWN:
				return Movement.DOWN;
			case KeyEvent.VK_LEFT:
				return Movement.LEFT;
			case KeyEvent.VK_RIGHT:
				return Movement.RIGHT;
			case KeyEvent.VK_SPACE:
				return Movement.SPACE ;
			default:
				return Movement.NOPE;
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
