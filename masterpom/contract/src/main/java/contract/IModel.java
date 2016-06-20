package contract;

import java.awt.Image;
import java.util.Observable;
/**
 * 
 * @author Asus
 *
 */
public interface IModel {

	public String getMessage();
	public void loadMessage(String key);
	public Observable getObservable();
	public int getWidth();
	public int getHeight() ;
	public Image[][] getWorldSprites() ;
	public Image[][] getMobileSprites() ;
	public void LorannMoveUP() ;
	public void LorannMoveUP_LEFT() ;
	public void LorannMoveLEFT() ;
	public void LorannMoveDOWN_LEFT();
	public void LorannMoveDOWN() ;
	public void LorannMoveDOWN_RIGHT() ;
	public void LorannMoveRIGHT() ;
	public void LorannMoveUP_RIGHT() ;
	public void getWorldAnswer() ;
	public void LorannMagicBall() ;
}
