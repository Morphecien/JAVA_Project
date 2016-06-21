package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * The class ViewPanel
 * 
 * @author Asus
 *
 */
class ViewPanel extends JPanel implements Observer {
	private ViewFrame					viewFrame;
	private static final long	serialVersionUID	= -998294702363713521L;
	private Image[][] mapSprites ;
	private Image[][] mobileSprites ;
	private int mapHeight;
	private int mapWidth;
	private GridBagConstraints gbc ;
	private GridBagLayout gbl;
	JLabel[][] allLabels = new JLabel[12][20] ;
	private static Dimension MAPDIMENSION = new Dimension(692, 428);
/**
 * Constructor of the ViewPanel
 * 
 * @param viewFrame
 * 			the viewFrame
 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
		mapSprites = new Image[12][20] ;
		mapHeight = this.getViewFrame().getModel().getHeight() ;
		mapWidth = this.getViewFrame().getModel().getWidth() ;
		gbc = new GridBagConstraints();
		gbl = new GridBagLayout() ;
		this.setSize(640, 384);
		this.setPreferredSize(MAPDIMENSION);;
		initGBC() ;
		this.mapSprites = this.getViewFrame().getModel().getWorldSprites() ;
		prepareAllJLabels() ;
	}
/**
 * Prepare the constraints for the GridBagLayout
 */
	private void initGBC(){
		gbc.gridx = 0 ;
		gbc.gridy = 0 ;
		gbc.gridheight = 1 ;
		gbc.gridwidth = 1 ;
	}
/**
 * Get the ViewFrame
 * @return viewFrame
 * 			the viewFrame
 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}
/**
 * Set the ViewFrame
 * @param viewFrame
 * 			the viewFrame
 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}
/**
 * Update() notifyObservver of Model
 */
	public void update(final Observable arg0, final Object arg1) {
		this.removeAll();
		prepareAllJLabels() ;
	}
	
/**
 * Method which prepare all JLabels
 */
	private void prepareAllJLabels(){
		JLabel[][] allLabels = new JLabel[mapHeight][mapWidth] ;
		this.mapSprites = this.getViewFrame().getModel().getWorldSprites() ;
		this.mobileSprites = this.getViewFrame().getModel().getMobileSprites() ;
		for (int y=0 ; y<mapHeight ; y++){
			gbc.gridy = y ;
			for (int x=0 ; x<mapWidth ; x++){
				gbc.gridx = x ;
				allLabels[y][x] = new JLabel() ;
				allLabels[y][x].setIcon(new ImageIcon(mapSprites[y][x]));
		//		System.out.print("1");
				if (mobileSprites[y][x] != null){
					allLabels[y][x].setIcon(new ImageIcon(mobileSprites[y][x])) ;
		//			System.out.print("8");
				}
		/*		if(mapSprites[y][x] == mapSprites[0][0] ){
					
				}
				else{
		//			System.out.print(" ") ;
				}*/
				gbl.setConstraints(allLabels[y][x], gbc);
				this.add(allLabels[y][x]) ;
			}
		//	System.out.println();
		}
		this.setLayout(gbl);
		this.getViewFrame().pack();
		this.setVisible(true);
		this.repaint();
	//	System.out.println("Et je repaint ;)");
	}
}
