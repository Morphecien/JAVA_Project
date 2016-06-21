package dao;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class for {@link dao.DAOMap}.
 * 
 * @author Samuel DUCANGE
 *
 */
public class DAOMapTest {
	/** The daoMap */
	private DAOMap daoMap ;
	/** The connection */
	static Connection connection ;
	
	/**
	 * Sets the up before class.
	 * 
	 * @throws Exception
	 *           the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		connection = DBConnection.getInstance().getConnection() ;
	}
	
	/**
	 * Tear down after class.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		connection = null ;
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@Before
	public void setUp() throws Exception {
		daoMap = new DAOMap(connection) ;
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@After
	public void tearDown() throws Exception {
		daoMap = null ;
	}

	/**
	 * Test method for dao.DAOMap#create().
	 */
	@Test
	public void testCreate() {
		Assert.assertEquals("The INSERT method has encountered a problem", true, daoMap.create());
	}
	
	/**
	 * Test method for dao.DAOMap#update().
	 */
	@Test
	public void testUpdate() {
		Assert.assertEquals("The UPDATE method has encountered a problem", true, daoMap.update(new Map()));
	}
	
	/**
	 * Test method for dao.DAOMap#delete().
	 */
	@Test
	public void testDelete() {
		Assert.assertEquals("The DELETE method has encountered a problem", true, daoMap.delete(new Map()));
	}
	
	/**
	 * Test method for dao.DAOMap#find(java.util.int).
	 */
	@Test
	public void testFind() {
		Assert.assertNotSame("The MAP-generator has encountered a problem", new Map(), daoMap.find(1));
	}
}
