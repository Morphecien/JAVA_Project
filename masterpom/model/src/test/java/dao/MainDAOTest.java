package dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link dao.MainDAO}.
 * 
 * @author Samuel DUCANGE
 *
 */
public class MainDAOTest {
	/** The MainDAO */
	private MainDAO dao ;
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@Before
	public void setUp() throws Exception {
		dao = new MainDAO() ;
	}
	
	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@After
	public void tearDown() throws Exception {
		dao = null ;
	}
	
	/**
	 * Test method for dao.MainDAO#MainDAO().
	 */
	@Test
	public void testMainDAO() {
		Assert.assertNotNull("The createMaps() method has encountered a problem", dao.daoMap);
	}
	
	/**
	 * Test method for dao.MainDAO#loadMap().
	 */
	@Test
	public void testLoadMap() {
		Assert.assertNotSame("The loadMap() method has encountered a problem", new Map(), dao.loadMap(1));
	}
	
}
