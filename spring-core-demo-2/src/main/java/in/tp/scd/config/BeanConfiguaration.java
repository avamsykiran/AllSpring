package in.tp.scd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.tp.scd.service.GreetNoteProvider;
import in.tp.scd.service.GreetNoteProviderTimeBasedImpl;
import in.tp.scd.service.GreetServiceAdvancedImpl;
import in.tp.scd.service.GreetServiceArgumentedImpl;
import in.tp.scd.service.GreetServiceStandardImpl;

@Configuration
public class BeanConfiguaration {

	@Bean
	public GreetServiceStandardImpl gs1() {
		return new GreetServiceStandardImpl();
	}
	
	@Bean
	public GreetServiceArgumentedImpl gs2() {
		
		//return new GreetServiceArgumentedImpl("Vanakkam");
		
		GreetServiceArgumentedImpl obj = new GreetServiceArgumentedImpl();
		obj.setGreetNote("Vanakkam");
		return obj;
	}

	@Bean
	public GreetNoteProviderTimeBasedImpl gp() {
		return new GreetNoteProviderTimeBasedImpl();
	}
}
