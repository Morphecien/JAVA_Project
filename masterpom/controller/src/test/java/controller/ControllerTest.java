package controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IModel;
import contract.Movement;
import model.Model;
import view.View;
/**
 * Test class for {@link controller.Controller}.
 * 
 * @author Samuel DUCANGE
 *
 */

public class ControllerTest {
	/** The model */
	private static IModel model ;
	/** The view */
	private static View view ;
	/** The Controller */
	private Controller controller ;
	/**
	 * Sets the up before class.
	 * 
	 * @throws Exception
	 *           the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		model = new Model() ;
		view = new View(model) ;
	}

	/**
	 * Tear down after class.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		view = null ;
		model = null ;
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@Before
	public void setUp() throws Exception {
		controller = new Controller(view, model) ;
		view.setController(controller) ;
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@After
	public void tearDown() throws Exception {
		controller = null ;
	}

	/**
	 * Test method for controler.Controller#movementLorann().
	 */
	@Test
	public void testMovementLorann() {
		int lastX = model.getXLorannPosition() ;
		int lastY = model.getYLorannPosition() ;
		controller.movementLorann(Movement.LEFT) ;
		Assert.assertEquals("X-move (LEFT) error", (lastX-1), model.getXLorannPosition()) ;
		lastX = model.getXLorannPosition() ;

		controller.movementLorann(Movement.RIGHT) ;
		Assert.assertEquals("X-move (RIGHT) error", (lastX+1), model.getXLorannPosition()) ;
		lastX = model.getXLorannPosition() ;
		
		controller.movementLorann(Movement.UP) ;
		Assert.assertEquals("Y-move (UP) error", (lastY-1), model.getYLorannPosition()) ;
		lastY = model.getYLorannPosition() ;
		
		controller.movementLorann(Movement.DOWN) ;
		Assert.assertEquals("Y-move (DOWN) error", (lastY+1), model.getYLorannPosition()) ;
		lastY = model.getYLorannPosition() ;
		
		
		controller.movementLorann(Movement.UP_LEFT) ;
		Assert.assertEquals("X-move (UP_LEFT) error", (lastX-1), model.getXLorannPosition()) ;
		Assert.assertEquals("X-move (UP_LEFT) error", (lastY-1), model.getYLorannPosition()) ;
		lastX = model.getXLorannPosition() ;
		lastY = model.getYLorannPosition() ;
		
		controller.movementLorann(Movement.DOWN_RIGHT) ;
		Assert.assertEquals("X-move (DOWN_RIGHT) error", (lastX+1), model.getXLorannPosition()) ;
		Assert.assertEquals("X-move (DOWN_RIGHT) error", (lastY+1), model.getYLorannPosition()) ;
		lastX = model.getXLorannPosition() ;
		lastY = model.getYLorannPosition() ;
		
		controller.movementLorann(Movement.DOWN_LEFT) ;
		Assert.assertEquals("X-move (DOWN_LEFT) error", (lastX-1), model.getXLorannPosition()) ;
		Assert.assertEquals("X-move (DOWN_LEFT) error", (lastY+1), model.getYLorannPosition()) ;
		lastX = model.getXLorannPosition() ;
		lastY = model.getYLorannPosition() ;
		
		controller.movementLorann(Movement.UP_RIGHT) ;
		Assert.assertEquals("X-move (UP_RIGHT) error", (lastX+1), model.getXLorannPosition()) ;
		Assert.assertEquals("X-move (UP_RIGHT) error", (lastY-1), model.getYLorannPosition()) ;
		lastX = model.getXLorannPosition() ;
		lastY = model.getYLorannPosition() ;		
		
	}
}
