package pluralsight.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import pluralsight.demo.filters.ProxyFilter;
import pluralsight.demo.filters.StartPreFilter;
import pluralsight.demo.filters.StopPostFilter;

@EnableZuulProxy
@SpringBootApplication
public class PluralsightZuulApiproxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PluralsightZuulApiproxyApplication.class, args);
	}
	
	@Bean
	public ProxyFilter proxyFilter() {
		return new ProxyFilter();
	}
	
	@Bean
	public StartPreFilter startPreFilter() {
		return new StartPreFilter();
	}
	
	@Bean
	public StopPostFilter stopPostFilter() {
		return new StopPostFilter();
	}
	
}
