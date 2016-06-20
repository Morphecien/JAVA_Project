package elementsMotionless;

import elementsAll.*;
/**
 * 
 * @author Asus
 *
 */
public abstract class MotionlessElement extends Element implements IElementsActionOnHeroes{
	private final String fileSymbol;
	/**
	 * 
	 */
	public MotionlessElement(final ISprite sprite, final Permeability permeability, final String fileSymbol) {
		super(sprite, permeability, Permeability.BLOCKING);
		this.fileSymbol = fileSymbol ;
	}
	/**
	 * 
	 * @param sprite
	 * @param permeabilityLorann
	 * @param permeabilityOther
	 * @param fileSymbol
	 */
	public MotionlessElement(final ISprite sprite, final Permeability permeabilityLorann, Permeability permeabilityOther, final String fileSymbol) {
		super(sprite, permeabilityLorann, permeabilityOther);
		this.fileSymbol = fileSymbol ;
	}
	/**
	 * 
	 * @return
	 */
	public String getFileSymbol() {
		return this.fileSymbol;
	}
/**
 * 
 */
	public ElementsActionsOnHeroes getElementActionOnHeroes() {
		return ElementsActionsOnHeroes.NOPE;
	}
}
