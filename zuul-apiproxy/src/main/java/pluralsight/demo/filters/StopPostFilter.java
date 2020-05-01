package pluralsight.demo.filters;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class StopPostFilter extends ZuulFilter {

	@Override
	public Object run() {
		
		Instant stop = Instant.now();

		//get start value
		RequestContext ctx = getCurrentContext();
		Instant start = (Instant)ctx.get("starttime");
		
		long secondsDifference = ChronoUnit.MILLIS.between(start, stop);
		System.out.println("Call took " + secondsDifference + " milliseconds.");

		
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "post";
	}

}
