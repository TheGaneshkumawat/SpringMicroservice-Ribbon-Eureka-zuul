package pluralsight.config.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.WeightedResponseTimeRule;


public class TollRateClientRuleConfiguration {

	@Autowired
	IClientConfig ribbonClientConfig;
	
	@Bean
	public IRule ribbonRule(IClientConfig iClientConfig)
	{
		return new WeightedResponseTimeRule();
	}
	
	//No need because Eureka is taking care of that
		/*
		 * @Bean public IPing pingRule() { return new PingUrl(); }
		
	} */
}
