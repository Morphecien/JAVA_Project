package elementsMobile;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link elementsMobile.MagicBall}.
 * 
 * @author Samuel DUCANGE
 *
 */
public class MagicBallTest {
	private MagicBall magicBall ;

	@Before
	public void setUp() throws Exception {
		magicBall = new MagicBall() ;
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@After
	public void tearDown() throws Exception {
		magicBall = null ;
	}

	/**
	 * Test method for {@link elementsMobile.MagicBall#prepareSprites()}.
	 */
	@Test
	public void testPrepareSprites() {
		Assert.assertEquals("Sprites were not initialize by the constructor.", magicBall.getGreenSprite(), magicBall.getSprites().get(0)) ;
		Assert.assertEquals("Sprites were not initialize by the constructor.", magicBall.getCyanSprite(), magicBall.getSprites().get(1)) ;
		Assert.assertEquals("Sprites were not initialize by the constructor.", magicBall.getPurpleSprite(), magicBall.getSprites().get(2)) ;
		Assert.assertEquals("Sprites were not initialize by the constructor.", magicBall.getRedSprite(), magicBall.getSprites().get(3)) ;
		Assert.assertEquals("Sprites were not initialize by the constructor.", magicBall.getYellowSprite(), magicBall.getSprites().get(4)) ;
	}



}
