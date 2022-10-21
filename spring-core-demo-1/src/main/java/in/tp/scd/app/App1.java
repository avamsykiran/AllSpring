package in.tp.scd.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.tp.scd.service.GreetService;
import in.tp.scd.service.GreetServiceArgumentedImpl;
import in.tp.scd.service.GreetServiceStandardImpl;

public class App1 {

	public static void main(String[] args) {
		// GreetService gs = new GreetServiceStandardImpl();
		// System.out.println(gs.greet("Indhikaa"));

		ApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");

		GreetService gs1 = (GreetService)context.getBean("gs1");
		System.out.println(gs1.greet("Indhikaa"));
				
		GreetService gs2 = (GreetService)context.getBean("gs2");
		System.out.println(gs2.greet("Indhikaa"));
		
		((GreetServiceArgumentedImpl)gs2).setGreetNote("Hai ");
		System.out.println(gs2.greet("Indhikaa"));
		
		GreetService gs2a = (GreetService)context.getBean("gs2");
		System.out.println(gs2a.greet("Indhikaa"));
		
		GreetService gs4 = (GreetService)context.getBean("gs4");
		System.out.println(gs4.greet("Indhikaa"));
		
	}

}
