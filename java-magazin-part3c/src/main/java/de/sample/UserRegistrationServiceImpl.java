package de.sample;

public class UserRegistrationServiceImpl implements UserRegistrationService {
	
	public User getUser() {
		return new User();
	}

	public RegistrationStatus register() {
		return RegistrationStatus.SUCCESSFUL;
	}
}
