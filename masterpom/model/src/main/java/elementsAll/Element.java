package elementsAll;

import java.awt.Image;

import world.Iworld;

/**
 * @author Samuel DUCANGE
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
	
	public ISprite getSprite() {
		return this.sprite ;
	}

	public void setSprite(final ISprite sprite) {
		this.sprite = sprite;
	}


	public Permeability getPermeabilityLorann() {
		return this.permeabilityLorann;
	}

	private void setPermeabilityLorann(final Permeability permeability) {
		this.permeabilityLorann = permeability;
	}
	
	public Permeability getPermeabilityOther() {
		return this.permeabilityOther;
	}

	private void setPermeabilityOther(final Permeability permeability) {
		this.permeabilityOther = permeability;
	}
	
	public Iworld getWorld() {
		return this.world;
	}

	public void setWorld(final Iworld world) {
		this.world = world;
	}
	
	public Image getImage() {
		return this.getSprite().getImage();
	}

}
