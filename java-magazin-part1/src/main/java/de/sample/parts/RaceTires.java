package de.sample.parts;

public class RaceTires extends Tires {

	public RaceTires(Rim rim) {
		super(rim);
	}
	
	@Override
	public String getSpec() {
		return "race tires";
	}

}
