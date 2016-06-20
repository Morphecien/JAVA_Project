package dao;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class for {@link dao.DAOCreateAllLevel}.
 * 
 * @author Samuel DUCANGE
 *
 */
public class DAOCreateAllLevelTest {
	/** The connection */
	static private Connection connection ;
	/** The DAOCreateAllLevel */
	private DAOCreateAllLevel daoLevel ;
	
	/**
	 * Sets the up before class.
	 * 
	 * @throws Exception
	 *           the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		connection = DBConnection.getInstance().getConnection();
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
		daoLevel = new DAOCreateAllLevel(connection) ;
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@After
	public void tearDown() throws Exception {
		daoLevel = null ;
	}

	/**
	 * Test method for {@link dao.DAOCreateAllLevel#insertAllLevel()}.
	 */
	@Test
	public void testInsertAllLevel() {
		Assert.assertEquals("The insertAllLevel method has encountered a problem.", true, daoLevel.insertAllLevel());
	}

}
