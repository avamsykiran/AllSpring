package in.tp.scd.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.tp.scd.service.GreetService;
import in.tp.scd.service.GreetServiceArgumentedImpl;
import in.tp.scd.service.GreetServiceStandardImpl;

public class App2 {

	public static void main(String[] args) {
	
		ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
		
		GreetService gs = (GreetService)context.getBean("gs");
		System.out.println(gs.greet("Indhikaa"));
		
	}

}
