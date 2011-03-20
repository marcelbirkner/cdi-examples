package de.sample.transactions;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import de.sample.entities.Customer;

public class PersistenceServiceTransaction {

	@Inject EntityManager em;

	// For Unit Test
	public PersistenceServiceTransaction(EntityManager em) {
		this.em = em;
	}

	public Customer findCustomerByCustomerId(int customerId) {
		Customer customer = em.find(Customer.class, customerId);
		return customer;
	}
}
