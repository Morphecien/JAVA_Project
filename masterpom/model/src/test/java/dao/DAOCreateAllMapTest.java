package dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class for {@link dao.DAOCreateAllMap}.
 * 
 * @author Samuel DUCANGE
 *
 */
public class DAOCreateAllMapTest {
	/** The Connection */
	private static Connection connection ;
	/** The DAOCreateAllMap */
	private DAOCreateAllMap daoAllMap ;
	
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
		daoAllMap = new DAOCreateAllMap(connection) ;
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@After
	public void tearDown() throws Exception {
		daoAllMap = null ;
	}

	/**
	 * Test method for dao.DAOCreateAllMap#createAll().
	 */
	@Test
	public void testCreateAll() {
		try {
			Assert.assertEquals("The insertAllLevel method has encountered a problem.", true, daoAllMap.createAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
