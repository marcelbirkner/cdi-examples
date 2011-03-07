package de.sample.parts;

public class Engine {

	private String type;

	public Engine(EngineParts parts) {
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSpec() {
		return "Engine Type :: " + type;
	}
}
