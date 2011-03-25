package de.sample;

import javax.inject.Inject;

import org.slf4j.Logger;

public class User {

	@Inject Logger log;
	
	private String email = "spam@webmail.de";
	
	public String getEmail() {
		log.info("getUser");
		return this.email;
	}
	public void setEmail(String email) {
		log.info("setEmail");
		this.email = email;
	}

}
