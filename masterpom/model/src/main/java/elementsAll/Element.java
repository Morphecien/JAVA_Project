package elementsAll;

import java.awt.Image;

import world.Iworld;

public class Element {
	private ISprite sprite;
	private Iworld world ;
	private Permeability	permeability;
	public Element(final ISprite sprite, final Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}
	
	public ISprite getSprite() {
		return this.sprite ;
	}

	public void setSprite(final ISprite sprite) {
		this.sprite = sprite;
	}


	public Permeability getPermeability() {
		return this.permeability;
	}

	private void setPermeability(final Permeability permeability) {
		this.permeability = permeability;
	}
	
	protected Iworld getWorld() {
		return this.world;
	}

	public void setWorld(final Iworld world) {
		this.world = world;
	}
	
	public Image getImage() {
		return this.getSprite().getImage();
	}

}
