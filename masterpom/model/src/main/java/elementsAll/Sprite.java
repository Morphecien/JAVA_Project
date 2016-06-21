package elementsAll;

import java.awt.Image;
import java.io.IOException;
import java.io.StringWriter;

import javax.imageio.ImageIO;

/**
 * The class Sprite
 * @author Samuel DUCANGE
 *
 */
public class Sprite extends StringWriter implements ISprite{
	private Image image ;
	private String c ;
	
	/**
	 * The constructor of Sprite
	 * @param c
	 * 			the symbol in consol
	 * @param image
	 * 			the symbol in Frame
	 */
	public Sprite(final String c, final String image) {
		this.write(c);
		this.c = c ;
		try {
			this.image = ImageIO.read(this.getClass().getResourceAsStream("/sprites/" + image));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get the image
	 * @return image
	 */
	public Image getImage() {
		return this.image;
	}

	/**
	 * Get the symbol
	 */
	public void getSymbol(){
		System.out.print(c);
	}
}
