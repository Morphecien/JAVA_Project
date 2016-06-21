package elementsMotionless;

import elementsAll.*;

/**
 * The abstract class MotionlessElement
 * 
 * @author Samuel DUCANGE
 *
 */
public abstract class MotionlessElement extends Element implements IElementsActionOnHeroes{
	private final String fileSymbol;
	
	/**
	 * Super constructor for all motionless Elements
	 * @param sprite
	 * 			the sprite
	 * @param permeability
	 * 			the permeability
	 * @param fileSymbol
	 * 			the fileSymbol
	 */
	public MotionlessElement(final ISprite sprite, final Permeability permeability, final String fileSymbol) {
		super(sprite, permeability, Permeability.BLOCKING);
		this.fileSymbol = fileSymbol ;
	}
	
	/**
	 * Super constructor for all motionless Elements
	 * @param sprite
	 * 			the sprite
	 * @param permeabilityLorann
	 * 			the permeabilityLorann
	 * @param permeabilityOther
	 * 			the permeabilityOther
	 * @param fileSymbol
	 * 			the FileSymbol
	 */
	public MotionlessElement(final ISprite sprite, final Permeability permeabilityLorann, Permeability permeabilityOther, final String fileSymbol) {
		super(sprite, permeabilityLorann, permeabilityOther);
		this.fileSymbol = fileSymbol ;
	}
	
	/**
	 * Get the FileSymbol
	 * @return fileSymbel
	 */
	public String getFileSymbol() {
		return this.fileSymbol;
	}

	/**
	 * Get the Action on heroes (default)
	 * @return NOPE
	 */
	public ElementsActionsOnHeroes getElementActionOnHeroes() {
		return ElementsActionsOnHeroes.NOPE;
	}
}
