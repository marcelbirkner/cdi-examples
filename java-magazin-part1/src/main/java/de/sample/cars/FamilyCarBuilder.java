package de.sample.cars;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import de.sample.Car;
import de.sample.parts.Body;
import de.sample.parts.Builder;
import de.sample.parts.Engine;
import de.sample.parts.Tires;
import de.sample.qualifier.EngineType;
import de.sample.qualifier.Family;

@Family
public class FamilyCarBuilder implements Builder {

	@Inject Tires tires;
	@Inject Body body;
	@Inject @EngineType(type = "diesel") Engine engine;

	@Produces
	public Car build() {
		return new FamilyCar( tires, body, engine );
	}
}
