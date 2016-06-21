package dao;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link dao.DBConnection}.
 * 
 * @author Samuel DUCANGE
 *
 */
public class DBConnectionTest {
	
	/**
	 * Test method for dao.DBConnection#getInstance().
	 */
	@Test
	public void testGetInstance() {
		Assert.assertNotNull("The instance of DBConnection was not initialized", DBConnection.getInstance());
	}
	
	/**
	 * Test method for dao.DBConnection#getConnection().
	 */
	@Test
	public void testGetConnection() {
		Assert.assertNotNull("The Connection of DBConnection was not initialized", DBConnection.getInstance().getConnection());
	}
}
