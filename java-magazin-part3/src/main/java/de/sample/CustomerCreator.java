package de.sample;

import javax.inject.Inject;

import de.sample.entities.Customer;

public class CustomerCreator {

	@Inject UniqueIdentifierUtil util;

	// For Unit Tests
	public CustomerCreator(UniqueIdentifierUtil util) {
		this.util = util;
	}
	
	public Customer createNewCustomer(String firstName, String lastName ) {
		Customer c = new Customer();
		c.setCustomerId( util.getNextCustomerId() );
		c.setFirstName(firstName);
		c.setLastName(lastName);
		return c;
	}
}
