package org.arquillian.example;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Hello {

	public String hello() {
		return "helloWorld";
	}
}
