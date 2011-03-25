package de.sample;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.weld.environment.se.events.ContainerInitialized;
import org.slf4j.Logger;

import de.sample.interceptors.AuditTime;

public class UserRegistration {

	@Inject Logger log;
	@Inject UserRegistrationService service;
	
	@AuditTime
	public void registerUser( @Observes ContainerInitialized init) throws InterruptedException {
		log.info( "Start registration"  );

		for (int i = 0; i < 10; i++) {
			log.info( "Registration Status: " + service.register() + "\n");
		}
		
		// Added for AuditTime Interceptor
		Thread.sleep( 10L );
		
		log.info( "End registration"  );
	}
}