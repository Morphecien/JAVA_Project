package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import contract.IController;
import contract.IModel;
/**
 * The class ViewFrame
 * 
 * @author Asus
 *
 */
class ViewFrame extends JFrame implements KeyListener, Runnable, ActionListener {
	private IModel						model;
	private IController				controller;
	private Timer timeEvent ;
	private TreeSet<Integer> treeSet= new TreeSet<Integer>();
	private static final long	serialVersionUID	= -697358409737458175L;
	private static Dimension MAPDIMENSION = new Dimension(692, 428);
	private int firstKeyCode = 0;
	private int secondKeyCode = 0;
	private int thirdKeyCode = 0;
	private int vkSpace_counter = 0 ;
/**
 * Constructor of the ViewFrame
 * 
 * @param model
 * 			the Imodel
 * @throws HeadlessException
 * 			the HeadlessException
 */
	public ViewFrame(final IModel model) throws HeadlessException {
		this.buildViewFrame(model);
		this.setTimeEvent(new Timer(100, this));
		this.run() ;
	}
/**
 * Constructor of the ViewFrame
 * 
 * @param model
 * 			the Imodel
 * @param gc
 * 			the GraphicsConfiguration
 */
	public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
		super(gc);
		this.buildViewFrame(model);
		this.setTimeEvent(new Timer(100, this));
		this.run() ;
	}
/**
 * Constructor of the ViewFrame
 * 
 * @param model
 * 			the IModel
 * @param title
 * 			the Title
 * @throws HeadlessException
 * 			the HeadlessException
 */
	public ViewFrame(final IModel model, final String title) throws HeadlessException {
		super(title);
		this.buildViewFrame(model);
		this.setTimeEvent(new Timer(100, this));
		this.run() ;
	}
/**
 * Constructor of the ViewFrame
 * 
 * @param model
 * 			the IModel
 * @param title
 * 			the Title
 * @param gc
 * 			the GraphicsConfiguration
 */
	public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
		super(title, gc);
		this.buildViewFrame(model);
		this.setTimeEvent(new Timer(100, this));
		this.run() ;
	}
/**
* Run() for the timer
*/
	public synchronized void run(){
		this.getTimeEvent().start();
	}
/**
 * Get the Controller
 * 
 * @return Controller 
 * 			the IController
 */
	private IController getController() {
		return this.controller;
	}
/**
 * Set the Controller
 * 
 * @param controller
 * 			the Controller
 */
	protected void setController(final IController controller) {
		this.controller = controller;
	}
/**
 * Get the model
 * 
 * @return IModel
 * 			the model
 */
	protected IModel getModel() {
		return this.model;
	}
/**
 * Set the model
 * 
 * @param model
 * 			the IModel
 */
	private void setModel(final IModel model) {
		this.model = model;
	}
/**
 * Create the Frame
 * 
 * @param model
 * 			the IModel
 */
	private void buildViewFrame(final IModel model) {
		this.setModel(model);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addKeyListener(this);
		this.setContentPane(new ViewPanel(this));
		//this.setSize(640 + this.getInsets().left + this.getInsets().right, 384 + this.getInsets().top + this.getInsets().bottom);
		this.setSize(MAPDIMENSION) ;
		this.setPreferredSize(MAPDIMENSION);
		this.setBackground(Color.BLACK);
		this.setLocationRelativeTo(null);
	}
/**
 * Create a small Frame with the message
 * 
 * @param message
 * 			the message
 */
	public void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, "Coucou c'est moi (:");
	}
/**
 * The method keyTyped() (KeyListener)
 */
	public void keyTyped(final KeyEvent e) {

	}
/**
 * The method keyPressed() (KeyListener)
 */
	public void keyPressed(final KeyEvent e) {
		this.getTreeSet().add(e.getExtendedKeyCode());
		Iterator<Integer> iteratorKeyCode = this.getTreeSet().iterator() ;
		this.setFirstKeyCode(iteratorKeyCode.next()) ;
		if(iteratorKeyCode.hasNext()){
			this.setSecondKeyCode(iteratorKeyCode.next()) ;
			if (iteratorKeyCode.hasNext()){
				this.setThirdKeyCode(iteratorKeyCode.next()) ;
			}
			
		}
		
	//	System.out.println("I find this : " + this.getFirstKeyCode() + ", this : " + this.getSecondKeyCode() + ", and this : " + this.getThirdKeyCode()) ;
	}
/**
 * The method keyReleased() (KeyListener)
 */
	public void keyReleased(final KeyEvent e) {
		this.treeSet.remove(e.getExtendedKeyCode());
		this.setFirstKeyCode(0) ;
		this.setSecondKeyCode(0) ;
		this.setThirdKeyCode(0) ;
	}
/**
 * Get the Treeset which contain the KeyCodes
 * 
 * @return treeset
 * 			the TreeSet
 */
	public TreeSet<Integer> getTreeSet() {
		return this.treeSet;
	}
/**
 * Set the Treeset which contain the KeyCodes
 * 
 * @param treeSet
 * 			the TreeSet
 */
	public void setTreeSet(TreeSet<Integer> treeSet) {
		this.treeSet = treeSet;
	}
/**
 * Get the Timer for execute the Event
 * 
 * @return timeEvent
 * 			the timer
 */
	public Timer getTimeEvent() {
		return timeEvent;
	}
/**
 * Set the Timer
 * 
 * @param timeEvent
 * 			the Timer
 */
	public void setTimeEvent(Timer timeEvent) {
		this.timeEvent = timeEvent;
	}
/**
 * Choose an action
 * @param e
 * 			the ActionEvent
 */
	public void actionPerformed(ActionEvent e) {
		boolean shootMagicBall = false;
		if (this.getThirdKeyCode() != 0){
			shootMagicBall = true ;
			if (this.getFirstKeyCode() == 32){
				this.getController().movementLorann(View.keyCodeToControllerMovement(getSecondKeyCode(),getThirdKeyCode()));
			}
			else if (this.getSecondKeyCode() == 32){
				this.getController().movementLorann(View.keyCodeToControllerMovement(getFirstKeyCode(),getThirdKeyCode()));
			}
			else {
				this.getController().movementLorann(View.keyCodeToControllerMovement(getFirstKeyCode(),getSecondKeyCode()));
			}
		}
		else{
			if (this.getFirstKeyCode() == 32){
				this.getController().movementLorann(View.keyCodeToControllerMovement(getSecondKeyCode(), 0));
				shootMagicBall = true ;
			}
			else if (this.getSecondKeyCode() == 32){
				this.getController().movementLorann(View.keyCodeToControllerMovement(getFirstKeyCode(), 0));
				shootMagicBall = true ;
			}
			else{
				this.getController().movementLorann(View.keyCodeToControllerMovement(getFirstKeyCode(),getSecondKeyCode()));
			}
		}
		if ((this.getVkSpace_counter() > 0) && (shootMagicBall)){
			this.setVkSpace_counter(this.getVkSpace_counter()-1);
		}
		else if ((this.getVkSpace_counter() == 0) && (shootMagicBall)){
			this.setVkSpace_counter(3);
			this.getController().movementLorann(View.keyCodeToControllerMovement(KeyEvent.VK_SPACE,0)) ;
		}
	}
/**
 * Get the counter for VK_Space
 * 
 * @return vkSpace_counter
 * 			the vkSpace_counter
 */
	public int getVkSpace_counter() {
		return vkSpace_counter;
	}
/**
 * Set the vk_space counter
 * 
 * @param vkSpace_counter
 * 			the vkSpace_counter
 */
	public void setVkSpace_counter(int vkSpace_counter) {
		this.vkSpace_counter = vkSpace_counter;
	}
/**
 * Get the first keycode
 * 
 * @return firstKeyCode
 * 			the firstKeyCode
 */
	public int getFirstKeyCode() {
		return firstKeyCode;
	}
/**
 * Set the first keycode
 * 
 * @param firstKeyCode
 * 			the firstKeyCode
 */
	public void setFirstKeyCode(int firstKeyCode) {
		this.firstKeyCode = firstKeyCode;
	}
/**
 * Get the second keycode
 * 
 * @return secondKeyCode
 * 			the secondKeyCode
 */
	public int getSecondKeyCode() {
		return secondKeyCode;
	}
/**
 * Set the second keycode
 * 
 * @param secondKeyCode
 * 			the secondKeyCode
 */
	public void setSecondKeyCode(int secondKeyCode) {
		this.secondKeyCode = secondKeyCode;
	}
/**
 * Get the third keycode
 * 
 * @return thirdKeyCode
 * 			the thirdKeyCode
 */
	public int getThirdKeyCode() {
		return thirdKeyCode;
	}
/**
 * Set the third keycode
 * 
 * @param thirdKeyCode
 * 			the thirdKeyCode
 */
	public void setThirdKeyCode(int thirdKeyCode) {
		this.thirdKeyCode = thirdKeyCode;
	}
}
