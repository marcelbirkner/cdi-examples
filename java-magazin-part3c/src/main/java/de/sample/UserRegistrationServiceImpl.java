package de.sample;

import java.util.Random;

public class UserRegistrationServiceImpl implements UserRegistrationService {
	
	private Random random = new Random();
	
	public User getUser() {
		User user = new User();
		int randomInteger = random.nextInt( 2 );
		if( randomInteger == 0 ) {
			user.setEmail("spam@mail.com");
		}
		return user;
	}

	public RegistrationStatus register() {
		return RegistrationStatus.SUCCESSFUL;
	}
}
