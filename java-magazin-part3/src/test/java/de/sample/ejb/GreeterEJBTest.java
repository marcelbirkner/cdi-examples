package de.sample.ejb;

import static org.junit.Assert.assertEquals;

import javax.ejb.EJB;

import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class GreeterEJBTest {

	@EJB private GreeterEJB greeter;

	@Deployment
	public static JavaArchive createTestArchive() {
		return ShrinkWrap.create(JavaArchive.class, "test.jar")
		.addClasses(GreeterEJB.class, GreeterEJBBean.class);
	}

	@Test
	public void testHelloEJB() {
		String result = greeter.welcome("John");
		assertEquals("Welcome to my world John", result);
	}
}

