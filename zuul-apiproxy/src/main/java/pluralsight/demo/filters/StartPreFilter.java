package pluralsight.demo.filters;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;

import java.time.Instant;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class StartPreFilter extends ZuulFilter {

	@Override
	public Object run() {
		
		RequestContext ctx = getCurrentContext();
		System.out.println(Instant.now());
		ctx.set("starttime", Instant.now());
		
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
		return 2;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
