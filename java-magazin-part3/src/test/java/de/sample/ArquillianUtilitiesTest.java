package de.sample;

import static org.testng.AssertJUnit.*;

import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.testng.annotations.Test;

public class ArquillianUtilitiesTest {

	@Test
	public void init() throws Exception {
		ArquillianUtilities utils = new ArquillianUtilities();
		assertNotNull( utils );
	}

	@Test
	public void createTestArchive() throws Exception {
		JavaArchive util = ArquillianUtilities.createArchive(String.class);
		assertNotNull( util );
		assertEquals( "test.jar", util.getName() );
	}
}
