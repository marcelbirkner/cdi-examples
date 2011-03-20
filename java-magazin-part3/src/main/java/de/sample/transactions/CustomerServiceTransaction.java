package de.sample.transactions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import de.sample.entities.Customer;

public class CustomerServiceTransaction {

	private EntityManager em = null;

	public CustomerServiceTransaction(EntityManager em) {
		this.em = em;
	}

	public boolean createNewCustomer( Customer customer ) {
		em.getTransaction().begin();
		em.persist( customer );
		em.getTransaction().commit();
		return true;
	}
	
	public Customer findCustomerByCustomerId( int customerId ) {
		return em.find( Customer.class, customerId );
	}

	public List<Customer> getCustomerFor( int customerId ) {
		TypedQuery<Customer> query = em.createQuery( "SELECT c from Customer c where c.customerId = :customerId", Customer.class );
		query.setParameter("customerId", customerId);
		List<Customer> result = query.getResultList();
		return result;
	}
}
