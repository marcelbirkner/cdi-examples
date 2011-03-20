package de.sample;

import static org.testng.AssertJUnit.assertNotNull;

import org.testng.annotations.Test;

public class CustomerServicePersistenceTest {
	
	@Test
	public void init() {
		CustomerServicePersistence persistence = new CustomerServicePersistence();
		assertNotNull( persistence.getEntityManagerFactory() );
	}
}
