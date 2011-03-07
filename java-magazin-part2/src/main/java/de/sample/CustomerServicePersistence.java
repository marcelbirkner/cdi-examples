package de.sample;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.sample.qualifier.CustomerService;

@Singleton
public class CustomerServicePersistence implements Serializable  {
	private static final long serialVersionUID = 1L;

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("production-persistence-unit");
	
	@Produces @CustomerService
	public EntityManagerFactory getEntityManagerFactory() {
		return factory;
	}
	
}
