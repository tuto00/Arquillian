package org.arquillian.example;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.arquillian.annotation.SampleInterceptor;

@Named
@ApplicationScoped
@SampleInterceptor
public class GreetService {

	@Inject
	Hello hello;

    public String greet(){
    	return hello.hello();
    }
}