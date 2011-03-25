package de.sample;

public enum RegistrationStatus {
	
	SUCCESSFUL("Registrierung erfolgreich"), 
	UNSUCCESSFUL("Registrierung nicht erfolgreich"), 
	SPAM("Registrierung aufgrund von Spam abgebrochen");

	private String status;
	
	RegistrationStatus(String status) {
		this.status = status;
	}
	
	public String toString() {
		return this.status;
	}
}
