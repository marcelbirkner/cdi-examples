package de.sample;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import de.sample.qualifier.CustomerService;

/**
 * Helper class to provide entity manager instances for the service
 * implementation. Injecting directly into the service failed due to
 * CDI/Glassfish Nullpointer Exceptions.
 */
@Singleton
public class CustomerServiceContext implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject @CustomerService EntityManagerFactory factory;

    public EntityManager createEntityManager() {
        return factory.createEntityManager();
    }
}
