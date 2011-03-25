package de.sample;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.weld.environment.se.events.ContainerInitialized;
import org.slf4j.Logger;

import de.sample.interceptors.AuditTime;

public class UserRegistration {

	@Inject Logger log;
	
	@AuditTime
	public void registerUser( @Observes ContainerInitialized init) throws InterruptedException {
		log.info( "Start registration"  );
		UserRegistrationService service = new UserRegistrationServiceImpl();
		log.info( service.register() );
	}
}