package view;

import org.junit.Assert;
import org.junit.Test;

import contract.Movement;

/**
 * Test class for {@link view.View}.
 * 
 * @author Samuel DUCANGE
 *
 */
public class ViewTest {
	
	/**
	 * Test method for view.View.keyCodeToControllerMovement().
	 */
	@Test
	public void testKeyCodeToControllerMovement() {
		Assert.assertEquals("The UP Movement was misinterpreted", Movement.UP, View.keyCodeToControllerMovement(38, 0));
		Assert.assertEquals("The LEFT Movement was misinterpreted", Movement.LEFT, View.keyCodeToControllerMovement(37, 0));
		Assert.assertEquals("The DOWN Movement was misinterpreted", Movement.DOWN, View.keyCodeToControllerMovement(40, 0));
		Assert.assertEquals("The RIGHT Movement was misinterpreted", Movement.RIGHT, View.keyCodeToControllerMovement(39, 0));
		
		Assert.assertEquals("The UP-LEFT Movement was misinterpreted", Movement.UP_LEFT, View.keyCodeToControllerMovement(38, 37));
		Assert.assertEquals("The UP-LEFT Movement was misinterpreted", Movement.UP_LEFT, View.keyCodeToControllerMovement(37, 38));
		Assert.assertEquals("The DOWN-LEFT Movement was misinterpreted", Movement.DOWN_LEFT, View.keyCodeToControllerMovement(40, 37));
		Assert.assertEquals("The DOWN-LEFT Movement was misinterpreted", Movement.DOWN_LEFT, View.keyCodeToControllerMovement(37, 40));
		Assert.assertEquals("The DOWN-RIGHT Movement was misinterpreted", Movement.DOWN_RIGHT, View.keyCodeToControllerMovement(40, 39));
		Assert.assertEquals("The DOWN-RIGHT Movement was misinterpreted", Movement.DOWN_RIGHT, View.keyCodeToControllerMovement(39, 40));
		Assert.assertEquals("The UP-RIGHT Movement was misinterpreted", Movement.UP_RIGHT, View.keyCodeToControllerMovement(38, 39));
		Assert.assertEquals("The UP-RIGHT Movement was misinterpreted", Movement.UP_RIGHT, View.keyCodeToControllerMovement(39, 38));
		
		Assert.assertEquals("The SPACE Movement was misinterpreted", Movement.SPACE, View.keyCodeToControllerMovement(32, 0));
	}

}
