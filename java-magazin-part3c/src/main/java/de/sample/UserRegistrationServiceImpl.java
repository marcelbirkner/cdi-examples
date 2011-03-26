package de.sample;

import java.util.Random;

import javax.inject.Inject;

import org.slf4j.Logger;

public class UserRegistrationServiceImpl implements UserRegistrationService {
	
	@Inject Logger log;
	
	private Random random = new Random();
	
	public User getUser() {
		User user = new User();
		int randomInteger = random.nextInt( 2 );
		if( randomInteger == 0 ) {
			log.debug("set spam email address");
			user.setEmail("spam@mail.com");
		}
		return user;
	}

	public RegistrationStatus register() {
		return RegistrationStatus.SUCCESSFUL;
	}
}
