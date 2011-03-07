package de.sample;

import static org.testng.AssertJUnit.*;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.Archives;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.impl.base.asset.ByteArrayAsset;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import de.sample.entities.Customer;
import de.sample.qualifier.CustomerService;

public class CustomerServiceImplTest extends Arquillian {
	
	@Deployment
	public static Archive<?> createTestArchive() throws IllegalArgumentException, IOException {
		JavaArchive archive = Archives.create("test-archive.jar", JavaArchive.class).
				addManifestResource( new ByteArrayAsset( new byte[0]), ArchivePaths.create("beans.xml") ).
				addClasses( CustomerServiceImpl.class, CustomerServiceContext.class, TestPersistence.class );
		return archive;
	}

	@Inject	CustomerServiceImpl underTest;
	
	@Inject @CustomerService EntityManagerFactory factory;

	int customerId = 42;
	String firstName = "John";
	String lastName = "Doe";

	@Test
	public void createCustomerShouldReturnSuccessful() {
		Customer c = new Customer();
		c.setCustomerId( 100 );
		c.setFirstName( firstName );
		c.setLastName( lastName );
		assertEquals(true, underTest.createNewCustomer( c ) );
	}

	@Test
	public void findCustomerByCustomerIdShouldReturnNewlyCreatedCustomer() {
		Customer c = new Customer();
		int cid = 100;
		c.setCustomerId( cid );
		c.setFirstName( firstName );
		c.setLastName( lastName );
		underTest.createNewCustomer( c );
		assertEquals(cid, underTest.findCustomerByCustomerId( cid ).getCustomerId() );
	}
	
	@Test
	public void getNonExistingCustomerShouldReturnAnEmptyList() {
		assertEquals(0, underTest.getCustomerFor( customerId ).size() );
	}

	@Test
	public void getExistingCustomerShouldReturnCustomer() {
		createCustomerInDatabase( customerId );
		List<Customer> customer = underTest.getCustomerFor( customerId );
		assertEquals(1, customer.size() );
		assertEquals(customerId, customer.get(0).getCustomerId());
		assertEquals(firstName, customer.get(0).getFirstName() );
		assertEquals(lastName, customer.get(0).getLastName() );
	}

	@AfterMethod
	public void cleanTables() {
		truncateTable(factory, "customer");
	}

	private void createCustomerInDatabase( int customerId ) {
		Customer customer = new Customer();
		customer.setCustomerId( customerId );
		customer.setFirstName( firstName );
		customer.setLastName( lastName );
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();
	}

	private void truncateTable(EntityManagerFactory factory, String tableName) {
		String deleteQueryString = "delete from " + tableName;
		EntityManager em = factory.createEntityManager();
		Query deleteQuery = em.createNativeQuery( deleteQueryString );
		em.getTransaction().begin();
		deleteQuery.executeUpdate();
		em.getTransaction().commit();
	}
}
