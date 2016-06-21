package dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link dao.Map}.
 * 
 * @author Samuel DUCANGE
 *
 */
public class MapTest {
	/** Tha Map */
	private Map map ;
	
	/**
	 * Sets the up before class.
	 * 
	 * @throws Exception
	 *           the exception
	 */
	@Before
	public void setUp() throws Exception {
		map = new Map() ;
	}
	
	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@After
	public void tearDown() throws Exception {
		map = null ;
	}
	
	/**
	 * Test method for dao.Map#setMap().
	 */
	@Test
	public void testSetMap() {
		String[][] map2 = new String[2][8] ;
		map.setMap(map2);
		Assert.assertSame("The Map was not correctly insert by the setter, or the Map return by the getter is not correct.", map2 , map.getMap()) ;
	}
}
