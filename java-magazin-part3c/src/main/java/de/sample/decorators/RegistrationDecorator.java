package de.sample.decorators;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

import org.slf4j.Logger;

import de.sample.RegistrationStatus;
import de.sample.User;
import de.sample.UserRegistrationService;

@Decorator
public abstract class RegistrationDecorator implements UserRegistrationService {

	private @Inject Logger log;

	private @Inject @Delegate UserRegistrationService service;

	public RegistrationStatus register() {
		log.info( "register :: check user if email address is possible spam");
		User u = service.getUser();
		if ( u.getEmail().startsWith("spam" ) ) {
			log.info( "spam email account found" );
			return RegistrationStatus.SPAM;
		}
		return service.register();
	}
}