package dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link dao.DBProperties}.
 * 
 * @author Samuel DUCANGE
 *
 */
public class DBPropertiesTest {
	/** The DataBase Properties */
	private static DBProperties dbProperties ;
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@Before
	public void setUp() throws Exception {
		dbProperties = new DBProperties() ;
	}
	
	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@After
	public void tearDown() throws Exception {
		dbProperties = null ;
	}
	
	/**
	 * Test method for dao.DBProperties#DBProperties().
	 */
	@Test
	public void testDBProperties(){
		Assert.assertNotNull("The instance of DBProperties was not created.", dbProperties) ;
	}
	
	/**
	 * Test method for dao.DBProperties#getURL().
	 */
	@Test
	public void testGetURL() {
		Assert.assertEquals("The URL return by the getter is not correct.", "jdbc:mysql://localhost/JAVA-Project?autoReconnect=true&useSSL=false", dbProperties.getUrl()) ;
	}
	
	/**
	 * Test method for dao.DBProperties#getLogin().
	 */
	@Test
	public void testGetLogin() {
		Assert.assertEquals("The Login return by the getter is not correct.", "root", dbProperties.getLogin()) ;
	}
	
	/**
	 * Test method for dao.DBProperties#getPassword().
	 */
	@Test
	public void testGetPassword() {
		Assert.assertEquals("The Password return by the getter is not correct.", "", dbProperties.getPassword()) ;
	}
}
