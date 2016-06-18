package contract;

import java.awt.Image;
import java.util.Observable;

public interface IModel {

	public String getMessage();
	public void loadMessage(String key);
	public Observable getObservable();
	public int getWidth();
	public int getHeight() ;
	public Image[][] getWorldSprites() ;
	public Image[][] getMobileSprites() ;
	public void LorannMoveUP() ;
	public void LorannMoveDOWN() ;
	public void LorannMoveLEFT() ;
	public void LorannMoveRIGHT() ;
	public void getWorldAnswer() ;
}
