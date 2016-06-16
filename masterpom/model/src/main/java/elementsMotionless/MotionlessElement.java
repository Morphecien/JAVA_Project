package elementsMotionless;

import elementsAll.*;

public abstract class MotionlessElement extends Element implements IElementsActionOnHeroes{
	private final String fileSymbol;
	
	public MotionlessElement(final ISprite sprite, final Permeability permeability, final String fileSymbol) {
		super(sprite, permeability);
		this.fileSymbol = fileSymbol ;
	}
	
	public String getFileSymbol() {
		return this.fileSymbol;
	}

	public ElementsActionsOnHeroes getElementActionOnHeroes() {
		return ElementsActionsOnHeroes.NOPE;
	}
}
