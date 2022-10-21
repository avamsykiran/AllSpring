package in.tp.scd.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.tp.scd.config.BeanConfiguaration;
import in.tp.scd.service.GreetService;

public class App1 {

	public static void main(String[] args) {

		ApplicationContext context = 
				new AnnotationConfigApplicationContext(BeanConfiguaration.class);

		GreetService gs1 = (GreetService) context.getBean("gs1");
		System.out.println(gs1.greet("Indhikaa"));
	}

}
