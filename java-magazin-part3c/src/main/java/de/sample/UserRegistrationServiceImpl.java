package de.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserRegistrationServiceImpl implements UserRegistrationService {

	private Logger log = LoggerFactory.getLogger( UserRegistrationServiceImpl.class );
	
	public User getUser() {
		log.info( "getUser");
		return new User();
	}

	public String register() {
		log.info("Register");
		return "Register";
	}
}
