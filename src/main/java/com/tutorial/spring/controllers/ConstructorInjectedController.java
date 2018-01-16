package com.tutorial.spring.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.tutorial.spring.services.IGreetingService;

/**
 * This class shows how constructor based dependency injection works.
 * 
 * @author Bastian Bräunel
 *
 */
@Controller
public class ConstructorInjectedController {

	private IGreetingService greetringService;

	/**
	 * The constructor is responsible for the dependency injection at creation
	 * 
	 * The object can't be created without injecting the dependency.
	 * This makes this implementation secure and reliable.
	 * 
	 * @param greetringService	will be injected by the spring framework
	 * @Qualifier("contructorGreetringService")		this tells spring to prioritize the ContructorGreetringService, instead of the other classes that implement IGreetingService
	 */
	public ConstructorInjectedController(IGreetingService greetringService) {
		this.greetringService = greetringService;
	}
	
	public String sayHello() {
		return greetringService.sayGreeting();
	}
	
}
