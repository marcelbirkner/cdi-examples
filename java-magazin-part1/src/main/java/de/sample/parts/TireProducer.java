package de.sample.parts;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import de.sample.qualifier.Sport;

public class TireProducer {

	@Produces Tires tire;
	
	@Produces @Sport Tires raceTires;
	
	@Inject
	public void createTires( Rim rim ) {
		tire = new Tires( rim );
	}
	
	@Inject
	public void createRaceTires( Rim rim ) {
		raceTires = new RaceTires( rim );
	}
}
