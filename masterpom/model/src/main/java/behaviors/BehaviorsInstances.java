/**
 * 
 */
package behaviors;

/**
 * @author Samuel DUCANGE
 *
 */
public abstract class BehaviorsInstances {
	public static final IBehavior IA_BOUNCE 								= new IA_Bounce();
	public static final IBehavior IA_CHOOSE_PLAYER_DIRECTION 				= new IA_ChoosePlayerDirection();
	public static final IBehavior IA_CHOOSE_PLAYER_DIRECTION_MAGICBALL 		= new IA_ChoosePlayerDirection_MagicBall();
	public static final IBehavior IA_CHOOSE_PLAYER_DIRECTION_IF_VIEW_PLAYER = new IA_ChoosePlayerDirection_IfViewPlayer();
	public static final IBehavior IA_FULL_RANDOM 							= new IA_FullRandom();
	public static final IBehavior IA_SIMPLE_MOVEMENT 						= new IA_SimpleMovement() ;
}
