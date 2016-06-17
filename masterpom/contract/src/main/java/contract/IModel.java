package contract;

import java.awt.Image;
import java.util.Observable;

public interface IModel {

	String getMessage();
	void loadMessage(String key);
	Observable getObservable();
	int getWidth();
	int getHeight() ;
	Image[][] getWorldSprites() ;
	Image[][] getMobileSprites() ;
}
