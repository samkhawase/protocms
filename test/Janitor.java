import org.junit.Test;

import play.test.Fixtures;
import play.test.UnitTest;


public class Janitor extends UnitTest {

	@Test
	public void cleanUp(){
		play.Logger.info("Inside @Before method()");
		Fixtures.deleteAllModels();

	}
}
