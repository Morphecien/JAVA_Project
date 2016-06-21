package dao;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class for {@link dao.DAOCreateAMap}.
 * 
 * @author Samuel DUCANGE
 *
 */
public class DAOCreateAMapTest {
	/** The connection */
	private static Connection connection ;
	/** The Map properties */
	private static MapProperties mapProp ;
	/** The DAOCreateAMap */
	private DAOCreateAMap daoOneMap ;
	/** The file */
	private static String file ;
	
	/**
	 * Sets the up before class.
	 * 
	 * @throws Exception
	 *           the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		connection = DBConnection.getInstance().getConnection() ;
		mapProp = new MapProperties() ;
		file = mapProp.getAccess() + "001" + mapProp.getTerminaison() ;
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
		mapProp = null ;
		file = null ;
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@Before
	public void setUp() throws Exception {
		daoOneMap = new DAOCreateAMap(connection, file) ;
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@After
	public void tearDown() throws Exception {
		daoOneMap = null ;
	}

	/**
	 * Test method for dao.DAOCreateAMap#createMap().
	 */
	@Test
	public void testCreateMap(){
		Assert.assertEquals("The insertAllLevel method has encountered a problem.", true, daoOneMap.getCreationValidation());
	}

}
