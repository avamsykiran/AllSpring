package in.tp.scd.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages= {"in.tp.scd"})
@PropertySource(value= {"classpath:application.properties"})
public class BeanConfiguaration {
	
	@Bean
	public LocalDate today() {
		return LocalDate.now();
	}

	
}
