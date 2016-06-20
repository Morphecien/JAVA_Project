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

	public ViewFrame(final IModel model) throws HeadlessException {
		this.buildViewFrame(model);
		this.setTimeEvent(new Timer(100, this));
		this.run() ;
	}

	public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
		super(gc);
		this.buildViewFrame(model);
		this.setTimeEvent(new Timer(100, this));
		this.run() ;
	}

	public ViewFrame(final IModel model, final String title) throws HeadlessException {
		super(title);
		this.buildViewFrame(model);
		this.setTimeEvent(new Timer(100, this));
		this.run() ;
	}

	public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
		super(title, gc);
		this.buildViewFrame(model);
		this.setTimeEvent(new Timer(100, this));
		this.run() ;
	}
	
	public synchronized void run(){
		this.getTimeEvent().start();
	}

	private IController getController() {
		return this.controller;
	}

	protected void setController(final IController controller) {
		this.controller = controller;
	}

	protected IModel getModel() {
		return this.model;
	}

	private void setModel(final IModel model) {
		this.model = model;
	}

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

	public void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public void keyTyped(final KeyEvent e) {

	}

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
		
		System.out.println("J'ai trouvé ça : " + this.getFirstKeyCode() + ", ça : " + this.getSecondKeyCode() + ", et ça : " + this.getThirdKeyCode()) ;
	}

	public void keyReleased(final KeyEvent e) {
		this.treeSet.remove(e.getExtendedKeyCode());
		this.setFirstKeyCode(0) ;
		this.setSecondKeyCode(0) ;
		this.setThirdKeyCode(0) ;
	}
	
	public TreeSet<Integer> getTreeSet() {
		return this.treeSet;
	}

	public void setTreeSet(TreeSet<Integer> treeSet) {
		this.treeSet = treeSet;
	}

	public Timer getTimeEvent() {
		return timeEvent;
	}

	public void setTimeEvent(Timer timeEvent) {
		this.timeEvent = timeEvent;
	}

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

	public int getVkSpace_counter() {
		return vkSpace_counter;
	}

	public void setVkSpace_counter(int vkSpace_counter) {
		this.vkSpace_counter = vkSpace_counter;
	}

	public int getFirstKeyCode() {
		return firstKeyCode;
	}

	public void setFirstKeyCode(int firstKeyCode) {
		this.firstKeyCode = firstKeyCode;
	}

	public int getSecondKeyCode() {
		return secondKeyCode;
	}

	public void setSecondKeyCode(int secondKeyCode) {
		this.secondKeyCode = secondKeyCode;
	}

	public int getThirdKeyCode() {
		return thirdKeyCode;
	}

	public void setThirdKeyCode(int thirdKeyCode) {
		this.thirdKeyCode = thirdKeyCode;
	}
}
