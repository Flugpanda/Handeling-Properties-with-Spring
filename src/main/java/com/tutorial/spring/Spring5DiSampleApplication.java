package com.tutorial.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.tutorial.spring.controllers.ConstructorInjectedController;
import com.tutorial.spring.controllers.MyController;
import com.tutorial.spring.controllers.PropertyInjectedController;
import com.tutorial.spring.controllers.SetterInjectedController;

@SpringBootApplication
public class Spring5DiSampleApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(Spring5DiSampleApplication.class, args);
		
		// getting an instance of a MyController-Bean from the spring context
		MyController controller = (MyController) context.getBean(MyController.class);

		controller.sayHallo();

//		 PropertyInjectedController
		System.out.println(context.getBean(PropertyInjectedController.class).sayHello() + " - PropertyInjectedController");
		
//		 SetterInjectedController
		System.out.println(context.getBean(SetterInjectedController.class).sayHello() + " - SetterInjectedController");
		
//		 ConstructorInjectedController
		System.out.println(context.getBean(ConstructorInjectedController.class).sayHello() + " - ConstructorInjectedController");
		
	}
}
