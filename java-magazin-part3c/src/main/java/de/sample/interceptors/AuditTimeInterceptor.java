package de.sample.interceptors;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;


@AuditTime
@Interceptor
public class AuditTimeInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject Logger log;

	@AroundInvoke
	public Object computeTimestamp(InvocationContext ctx ) throws Exception {
		String simpleClassName = ctx.getMethod().getDeclaringClass().getSimpleName();
		String methodName = ctx.getMethod().getName();
		log.info( String.format( "Start :: %s.%s", simpleClassName, methodName ) );

		long start = System.currentTimeMillis();
		Object object = ctx.proceed();
		long stop = System.currentTimeMillis();

		log.info( String.format( "Invocation time :: %s.%s is %s", 
				simpleClassName, methodName, String.valueOf( stop - start ) ) );
		return object;
	}
}