package dao;

import java.sql.Connection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link dao.DAOEntity}.
 * 
 * @author Samuel DUCANGE
 *
 */
public class DAOEntityTest {
	/** The connection */
	Connection dbConnection ;
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@Before
	public void setUp() throws Exception {
		dbConnection = DBConnection.getInstance().getConnection() ;
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@After
	public void tearDown() throws Exception {
		dbConnection = null ;
	}
	
	/**
	 * Test method for dao.DAOEntity#getConnection().
	 */
	@Test
	public void testGetConnection() {
		Assert.assertEquals("The connection return by the getter is not correct.", dbConnection, DBConnection.getInstance().getConnection()) ;
	}

}
