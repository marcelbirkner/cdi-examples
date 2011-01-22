package de.sample.cars;

import javax.inject.Inject;

import de.sample.Car;
import de.sample.parts.Body;
import de.sample.parts.Builder;
import de.sample.parts.Engine;
import de.sample.parts.Tires;
import de.sample.qualifier.EngineType;
import de.sample.qualifier.Sport;

@Sport
public class SportsCarBuilder implements Builder {

	@Inject @Sport Tires tires;
	@Inject Body body;
	@Inject @EngineType(type="racefuel") Engine engine;

	public Car build() {
		return new SportsCar( tires, body, engine );
	}
}
