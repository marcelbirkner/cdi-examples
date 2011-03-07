package de.sample.cars;

import de.sample.Car;
import de.sample.parts.Body;
import de.sample.parts.Engine;
import de.sample.parts.Tires;

public class SportsCar implements Car {

	private Tires tires;
	private Body body;
	private Engine engine;

	public SportsCar(Tires tires, Body body, Engine engine) {
		this.tires = tires;
		this.body = body;
		this.engine = engine;
	}

	public String displayFeatures() {
		return "\n\nI am a " + this.getClass().getSimpleName() + " and these are my features:  \n" +
		"- tires  :: " + tires.getSpec()  + "\n" +
		"- body   :: " + body.getSpec()   + "\n" +
		"- engine :: " + engine.getSpec() + "\n";
	}
}
