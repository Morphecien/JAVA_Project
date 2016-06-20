package elementsAll;

import java.awt.Image;

import world.Iworld;
/**
 * 
 * @author Asus
 *
 */
public class Element {
	private ISprite sprite;
	private Iworld world ;
	private Permeability	permeabilityLorann;
	private Permeability	permeabilityOther;
	public Element(final ISprite sprite, final Permeability permeabilityLorann, final Permeability permeabilityOther) {
		this.setSprite(sprite);
		this.setPermeabilityLorann(permeabilityLorann);
		this.setPermeabilityOther(permeabilityOther);
	}
	/**
	 * 
	 * @return
	 */
	public ISprite getSprite() {
		return this.sprite ;
	}
/**
 * 
 * @param sprite
 */
	public void setSprite(final ISprite sprite) {
		this.sprite = sprite;
	}

/**
 * 
 * @return
 */
	public Permeability getPermeabilityLorann() {
		return this.permeabilityLorann;
	}
/**
 * 
 * @param permeability
 */
	private void setPermeabilityLorann(final Permeability permeability) {
		this.permeabilityLorann = permeability;
	}
	/**
	 * 
	 * @return
	 */
	public Permeability getPermeabilityOther() {
		return this.permeabilityOther;
	}
/**
 * 
 * @param permeability
 */
	private void setPermeabilityOther(final Permeability permeability) {
		this.permeabilityOther = permeability;
	}
	/**
	 * 
	 * @return
	 */
	public Iworld getWorld() {
		return this.world;
	}
/**
 * 
 * @param world
 */
	public void setWorld(final Iworld world) {
		this.world = world;
	}
	/**
	 * 
	 * @return
	 */
	public Image getImage() {
		return this.getSprite().getImage();
	}

}
