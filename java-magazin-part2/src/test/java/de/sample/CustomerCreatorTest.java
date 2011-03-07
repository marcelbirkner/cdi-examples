package de.sample;

import static org.testng.AssertJUnit.assertEquals;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import de.sample.entities.Customer;

public class CustomerCreatorTest {
	
	@Mock UniqueIdentifierUtil util;

	CustomerCreator underTest;

	int customerId = 42;
	String firstName = "John";
	String lastName = "Doe";
	
	@BeforeMethod
	public void setup() {
		MockitoAnnotations.initMocks(this);
		underTest = new CustomerCreator( util );
	}
	
	@Test
	public void createNewCustomerShouldReturnNewlyCreatedCustomerWithCustomerIdOne() {
		when( util.getNextCustomerId() ).thenReturn( customerId );
		Customer newCustomer = underTest.createNewCustomer(firstName, lastName);
		assertEquals(customerId, newCustomer.getCustomerId() );
		assertEquals(firstName, newCustomer.getFirstName() );
		assertEquals(lastName, newCustomer.getLastName() );
	}
}
