package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.IController;
import contract.IModel;
import contract.IView;
import contract.Movement;

/**
 * 
 * @author Asus
 *
 */
public class View implements IView, Runnable {
	private final ViewFrame viewFrame;
/**
 * 
 * @param model
 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model, "Lorann");
		SwingUtilities.invokeLater(this);
	}
/**
 * 
 * @param keyCode1
 * @param keyCode2
 * @return
 */
	protected static Movement keyCodeToControllerMovement(final int keyCode1, final int keyCode2) {
		
		switch (keyCode1) {
			case KeyEvent.VK_UP:
				switch(keyCode2){
					case KeyEvent.VK_LEFT : return Movement.UP_LEFT;
					case KeyEvent.VK_RIGHT : return Movement.UP_RIGHT;
					default : return Movement.UP;
				}
			case KeyEvent.VK_DOWN:
				switch(keyCode2){
					case KeyEvent.VK_LEFT : return Movement.DOWN_LEFT;
					case KeyEvent.VK_RIGHT : return Movement.DOWN_RIGHT;
					default : return Movement.DOWN;
				}
			case KeyEvent.VK_LEFT:
				switch(keyCode2){
					case KeyEvent.VK_UP : return Movement.UP_LEFT;
					case KeyEvent.VK_DOWN : return Movement.DOWN_LEFT;
					default : return Movement.LEFT;
				}
				
			case KeyEvent.VK_RIGHT:
				switch(keyCode2){
					case KeyEvent.VK_UP : return Movement.UP_RIGHT;
					case KeyEvent.VK_DOWN : return Movement.DOWN_RIGHT;
					default : return Movement.RIGHT;
				}
			case KeyEvent.VK_SPACE:
				return Movement.SPACE ;
			default:
				return Movement.NOPE;
		}
	}
/**
 * 
 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}
/**
 * 
 */
	public void run() {
		this.viewFrame.setVisible(true);
	}
/**
 * 
 * @param controller
 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}
