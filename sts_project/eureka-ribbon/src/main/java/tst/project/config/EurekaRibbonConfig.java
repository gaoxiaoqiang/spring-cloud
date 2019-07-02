package tst.project.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@Configuration
public class EurekaRibbonConfig {

	
	  @Bean // 初始化 Bean
	    @LoadBalanced // 实现负载均衡
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
	  
	  @Bean
	    public ServletRegistrationBean getServlet() {
	        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
	        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
	        registrationBean.setLoadOnStartup(1);
	        registrationBean.addUrlMappings("/hystrix.stream");
	        registrationBean.setName("HystrixMetricsStreamServlet");
	        return registrationBean;
	    }

}
