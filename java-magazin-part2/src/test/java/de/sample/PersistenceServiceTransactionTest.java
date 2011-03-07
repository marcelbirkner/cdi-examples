package de.sample;

import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;

import javax.persistence.EntityManager;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import de.sample.entities.Customer;
import de.sample.transactions.PersistenceServiceTransaction;

public class PersistenceServiceTransactionTest {

	@Mock EntityManager em;

	PersistenceServiceTransaction underTest;

	int customerId = 42;
	String firstName = "FirstName";
	String lastName = "LastName";
	
	@BeforeMethod
	public void setup() {
		MockitoAnnotations.initMocks(this);
		underTest = new PersistenceServiceTransaction( em );
	}
	
	@BeforeMethod
	public void freezeTime() {
		DateTimeUtils.setCurrentMillisFixed( System.currentTimeMillis() );
	}
	
	@AfterMethod
	public void unfreezeTime() {
		DateTimeUtils.setCurrentMillisSystem();
	}
	
	@Test
	public void findCustomerByNonExistingCustomerIdShouldReturnNull() {
		Customer foundCustomer = underTest.findCustomerByCustomerId( customerId );
		assertNull( foundCustomer );
	}
	
	@Test
	public void findCustomerByValidCustomerIdShouldReturnCustomer() {
		when( em.find( Customer.class, customerId) ).thenReturn( getCustomerStub( customerId ) );

		Customer foundCustomer = underTest.findCustomerByCustomerId( customerId );
		assertEquals(customerId, foundCustomer.getCustomerId() );
		assertEquals(firstName, foundCustomer.getFirstName() );
		assertEquals(lastName, foundCustomer.getLastName() );
	}

	@Test
	public void findCustomerByValidCustomerIdShouldReturnCustomerWithCurrentCreationTime() {
		when( em.find( Customer.class, customerId) ).thenReturn( getCustomerStub( customerId ) );

		Customer foundCustomer = underTest.findCustomerByCustomerId( customerId );
		assertEquals(new DateTime().toDate(), foundCustomer.getCreationTime() );
	}
	
	private Customer getCustomerStub( int customerId ) {
		Customer customer = new Customer();
		customer.setCustomerId( customerId );
		customer.setFirstName( firstName );
		customer.setLastName( lastName );
		return customer;
	}
}