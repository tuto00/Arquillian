package org.arquillian.example;

import static org.junit.Assert.*;

import java.io.File;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class GreeterTest {

	@Inject
	GreetService greeter;

	@Deployment
	public static JavaArchive createDeployment() {
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
				// .addClasses(Greeter.class,Hello.class)
				.addPackage("org.arquillian.example")
				.addPackage("org.arquillian.annotation")
				.addPackage("org.arquillian.interceptor")
				//.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
				.addAsManifestResource(new File("src/main/webapp/WEB-INF/beans.xml"));
		System.out.println(jar.toString(true));
		return jar;
	}

	@Test
	public void should_create_greeting() {
		// Assert.assertEquals("Hello, Earthling!",
		// greeter.createGreeting("Earthling"));
		// greeter.greet(System.out, "Earthling");
		assertEquals("helloWorld", greeter.greet());
	}

}
