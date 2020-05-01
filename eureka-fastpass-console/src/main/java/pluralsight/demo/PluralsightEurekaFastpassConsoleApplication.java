package pluralsight.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

import pluralsight.config.demo.FastPassClientRuleConfiguration;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PluralsightEurekaFastpassConsoleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PluralsightEurekaFastpassConsoleApplication.class, args);
	}
}
