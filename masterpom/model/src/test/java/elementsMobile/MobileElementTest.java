package elementsMobile;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.World;

/**
 * Test class for elementsMobile.MobileElement.
 * 
 * @author Samuel DUCANGE
 *
 */
public class MobileElementTest {
	private MobileElement mobileElement ;
	private static World world ;
	
	/**
	 * Sets the up before class.
	 * 
	 * @throws Exception
	 *           the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		world = new World(1) ;
	}

	/**
	 * Tear down after class.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@Before
	public void setUp() throws Exception {
		mobileElement = new Lorann() ;
		mobileElement.setWorld(world);
		
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for elementsMobile.MobileElement#setX().
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testSetX() {
		mobileElement.setX(5);
		Assert.assertEquals("The Yposition was not correctly change by the setter (or raise by the getter).", 5, mobileElement.getX()) ;
		mobileElement.setX(-1);
		Assert.fail("The setter has not raise the exception") ;
	}

	/**
	 * Test method for elementsMobile.MobileElement#setY().
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testSetY(){
		mobileElement.setY(5);
		Assert.assertEquals("The Yposition was not correctly change by the setter (or raise by the getter).", 5, mobileElement.getY()) ;
		mobileElement.setY(-1);
		Assert.fail("The setter has not raise the exception") ;
	}

}
