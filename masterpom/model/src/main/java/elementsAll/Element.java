package elementsAll;

import java.awt.Image;

import model.Iworld;

/**
 * The class Element
 * @author Samuel DUCANGE
 *
 */
public class Element {
	private ISprite sprite;
	private Iworld world ;
	private Permeability	permeabilityLorann;
	private Permeability	permeabilityOther;
	/**
	 * The constructor of Element
	 * @param sprite
	 * 			the sprite
	 * @param permeabilityLorann
	 * 			the permeabilityLorann
	 * @param permeabilityOther
	 * 			the permeabilityOther
	 */
	public Element(final ISprite sprite, final Permeability permeabilityLorann, final Permeability permeabilityOther) {
		this.setSprite(sprite);
		this.setPermeabilityLorann(permeabilityLorann);
		this.setPermeabilityOther(permeabilityOther);
	}
	
	/**
	 * Get the Sprite
	 * @return sprite
	 */
	public ISprite getSprite() {
		return this.sprite ;
	}

	/**
	 * Set the sprite
	 * @param sprite
	 * 			the sprite
	 */
	public void setSprite(final ISprite sprite) {
		this.sprite = sprite;
	}

	/**
	 * Get the Permeability with Lorann
	 * @return permeabilityLorann
	 */
	public Permeability getPermeabilityLorann() {
		return this.permeabilityLorann;
	}

	/**
	 * Set the Permeability with Lorann
	 * @param permeability
	 * 			the Lorann permeability
	 */
	private void setPermeabilityLorann(final Permeability permeability) {
		this.permeabilityLorann = permeability;
	}
	
	/**
	 * Get the Permeability with the Other mobiles
	 * @return permeability
	 */
	public Permeability getPermeabilityOther() {
		return this.permeabilityOther;
	}

	/**
	 * Set the Permeability with Lorann
	 * @param permeability
	 * 			the Other permeability
	 */
	private void setPermeabilityOther(final Permeability permeability) {
		this.permeabilityOther = permeability;
	}
	
	/**
	 * Get the world
	 * @return world
	 */
	public Iworld getWorld() {
		return this.world;
	}

	/**
	 * Set the world
	 * @param world
	 * 			the world
	 */
	public void setWorld(final Iworld world) {
		this.world = world;
	}
	
	/**
	 * Get the Image
	 * @return Image
	 */
	public Image getImage() {
		return this.getSprite().getImage();
	}
}
