package elementsAll;

import java.awt.Image;
import java.io.IOException;
import java.io.StringWriter;

import javax.imageio.ImageIO;

public class Sprite extends StringWriter implements ISprite{
	private Image image ;
	private String c ;
	public String test ;
	
	public Sprite(final String c, final String image) {
		this.write(c);
		this.c = c ;
		System.out.println(image + " : " + c) ;
		this.test = image ;
		try {
			this.image = ImageIO.read(this.getClass().getResourceAsStream("/sprites/" + image));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	public Image getImage() {
		return this.image;
	}

	
	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public void getSymbol(){
		System.out.print(c);
	}
}
