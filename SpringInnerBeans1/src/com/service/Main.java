package com.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/service/applicationContext.xml");
		
		HelloWorld helloworld = (HelloWorld) context.getBean("helloWorldBean");
		
		System.out.println(helloworld);
	}
}
