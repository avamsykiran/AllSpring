package in.tp.scd.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.tp.scd.config.BeanConfiguaration;
import in.tp.scd.service.GreetService;
import in.tp.scd.service.GreetServiceAdvancedImpl;

public class App1 {

	public static void main(String[] args) {

		ApplicationContext context = 
				new AnnotationConfigApplicationContext(BeanConfiguaration.class);

		GreetService gs1 = (GreetService) context.getBean("gs1");
		System.out.println(gs1.greet("Indhikaa"));
		
		GreetService gs2 = (GreetService) context.getBean("gs2");
		System.out.println(gs2.greet("Indhikaa"));
	
		//GreetService gs3 = (GreetService) context.getBean(GreetServiceAdvancedImpl.class);
		GreetService gs3 = (GreetService) context.getBean("greetServiceAdvancedImpl");
		System.out.println(gs3.greet("Indhikaa"));
	
	}

}
