package dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link dao.MapProperties}.
 * 
 * @author Samuel DUCANGE
 *
 */
public class MapPropertiesTest {
	/** The Map Properties */
	private MapProperties mapProp ;
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@Before
	public void setUp() throws Exception {
		mapProp = new MapProperties() ;
	}
	
	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@After
	public void tearDown() throws Exception {
		mapProp = null ;
	}
	
	/**
	 * Test method for dao.MapProperties#getAccess().
	 */
	@Test
	public void testGetAccess() {
		Assert.assertEquals("The Access File return by the getter is not correct", "/cryptes/salle", mapProp.getAccess());
	}
	
	/**
	 * Test method for dao.MapProperties#getTerminaison().
	 */
	@Test
	public void testGetTerminaison() {
		Assert.assertEquals("The Terminaison File return by the getter is not correct", ".txt", mapProp.getTerminaison());
	}
	
	/**
	 * Test method for dao.MapProperties#getNberLevel().
	 */
	@Test
	public void testGetNberLevel() {
		Assert.assertEquals("The Number of level return by the getter is not correct", 101, mapProp.getNberLevel());
	}
}
