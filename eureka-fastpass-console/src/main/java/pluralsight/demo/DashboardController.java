package pluralsight.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import pluralsight.config.demo.TollRateClientRuleConfiguration;

@RibbonClient(name="tollrate-service",configuration = TollRateClientRuleConfiguration.class)
@Controller
public class DashboardController {
	
	
	@LoadBalanced
	@Bean
	public RestTemplate tollrateRestTemplate(RestTemplateBuilder builder) {
		return builder.build();		
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getToolBackBackup")
	@RequestMapping("/dashboard")
	public ResponseEntity<TollRate> getTollRate(@RequestParam int stationId, Model m) {
		
		TollRate tr = restTemplate.getForObject("http://tollrate-service/tollrate/" + stationId, TollRate.class);
		System.out.println("stationId: " + stationId);
		m.addAttribute("rate", tr.getCurrentRate());
		return new ResponseEntity<TollRate>(tr, HttpStatus.OK);
	}
	
	public ResponseEntity<TollRate> getToolBackBackup(@RequestParam int stationId, Model m) {
		System.out.println("Method getToolBackBackup is called.");
		TollRate tr = new TollRate();
		tr.setCurrentRate(new BigDecimal(1));
		m.addAttribute("rate", "1.00");
		return new ResponseEntity<TollRate>(tr, HttpStatus.OK);
	}
	
}
