package de.sample;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFactory {

	@Produces 
	Logger createLogger( InjectionPoint injectionPoint ) { 
		return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass().getName()); 
	}
}