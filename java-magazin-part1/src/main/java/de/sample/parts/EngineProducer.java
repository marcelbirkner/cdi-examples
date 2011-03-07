package de.sample.parts;

import java.lang.annotation.Annotation;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import de.sample.qualifier.EngineType;

public class EngineProducer {

	@Produces @EngineType(type = "gas")
	public Engine createEngine( InjectionPoint ip, EngineParts parts ) {
		
		Engine engine = new Engine( parts );
		
		for( Annotation qualifier : ip.getQualifiers() ) {
			if( qualifier instanceof EngineType ) {
				EngineType type = (EngineType) qualifier;
				engine.setType( type.type() );
			}
		}
		return engine;
	}
}
