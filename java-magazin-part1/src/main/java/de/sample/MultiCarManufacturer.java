package de.sample;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.weld.environment.se.events.ContainerInitialized;
import org.slf4j.Logger;

import de.sample.parts.Builder;
import de.sample.qualifier.Family;
import de.sample.qualifier.Sport;

public class MultiCarManufacturer {

	@Inject @Sport  Builder sportCarBuilder;
	@Inject @Family Builder familyCarBuilder;
	
	@Inject Logger log;
	
	public void createSportsCar(@Observes ContainerInitialized init) {
		log.info( sportCarBuilder.build().displayFeatures() );
	}
	
	public void createFamilyCar(@Observes ContainerInitialized init) {
		log.info( familyCarBuilder.build().displayFeatures() );
	}
}
