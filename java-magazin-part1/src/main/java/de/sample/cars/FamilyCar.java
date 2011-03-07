package de.sample.cars;

import de.sample.Car;
import de.sample.parts.Body;
import de.sample.parts.Engine;
import de.sample.parts.Tires;

public class FamilyCar implements Car {

	Tires tires;
	Body body;
	Engine engine;

	public FamilyCar(Tires tires, Body body, Engine engine) {
		this.tires = tires;
		this.body = body;
		this.engine = engine;
	}

	public String displayFeatures() {
		return "\n\nI am a Family Car and these are my features:  \n" +
		"- tires  :: " + tires.getSpec()  + "\n" +
		"- body   :: " + body.getSpec()   + "\n" +
		"- engine :: " + engine.getSpec() + "\n";
	}
}
