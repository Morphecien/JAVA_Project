package elementsMotionless;

import elementsAll.*;

public abstract class MotionlessElement extends Element implements IElementsActionOnHeroes{
	private final char fileSymbol;
	
	public MotionlessElement(final ISprite sprite, final Permeability permeability, final char fileSymbol) {
		super(sprite, permeability);
		this.fileSymbol = fileSymbol ;
	}
	
	public char getFileSymbol() {
		return this.fileSymbol;
	}

	public ElementsActionsOnHeroes getElementActionOnHeroes() {
		return ElementsActionsOnHeroes.NOPE;
	}
}
