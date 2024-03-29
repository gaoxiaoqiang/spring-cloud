package tst.project.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class AuthFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true; // 是否执行该过滤器，此处为true，说明需要过滤
	}

	@Override
	public Object run() throws ZuulException {
		
		RequestContext ctx=RequestContext.getCurrentContext();
		HttpServletRequest request=ctx.getRequest();
		
		  String token = request.getParameter("token");// 获取请求的参数
		
		if("gxq".equals(token)) {
			
			 ctx.setSendZuulResponse(true); //对请求进行路由
	         ctx.setResponseStatusCode(200);
	         ctx.set("code", 1);
			
		}else {
			
			 ctx.setSendZuulResponse(false); //不对其进行路由
	            ctx.setResponseStatusCode(401);
	            HttpServletResponse response = ctx.getResponse();
	            response.setHeader("content-type", "text/html;charset=utf8");
	            ctx.setResponseBody("网关认证失败，停止路由");
	            ctx.set("code", 0);
			
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;// filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
	}

}
