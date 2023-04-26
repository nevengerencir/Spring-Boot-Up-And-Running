package nevengerencir.coffeeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class CoffeeapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeapiApplication.class, args);
	}

}
