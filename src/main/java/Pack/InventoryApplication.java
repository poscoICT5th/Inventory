package Pack;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class InventoryApplication extends SpringBootServletInitializer{
	// war deploy
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(InventoryApplication.class);
	}
	// rabbitmq
	@Bean
	Jackson2JsonMessageConverter jackson2JsonMessageConverter (){
		return new Jackson2JsonMessageConverter();
	}
	
		
	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}
}
