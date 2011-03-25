package de.sample.decorators;

import java.io.Serializable;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

import org.slf4j.Logger;

import de.sample.User;
import de.sample.UserRegistrationService;

@Decorator
public abstract class RegistrationDecorator implements UserRegistrationService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject private Logger log;

	@Inject @Delegate UserRegistrationService service;

	public String register() {
		log.info( "register :: check if Email is spam");
		User u = service.getUser();
		if ( u.getEmail().startsWith("spam" ) ) {
			log.info( "Spam Email Account" );
			return "Spam";
		}
		return service.register();
	}
}