package elementsAll;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.imageio.ImageIO;

public class Sprite extends StringWriter implements ISprite{
	private Image image ;
	
	public Sprite(final String c, final String image) {
		this.write(c);
		try {
			this.image = ImageIO.read(this.getClass().getResourceAsStream("/sprites/" + image));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	public Image getImage() {
		return this.image;
	}
}
