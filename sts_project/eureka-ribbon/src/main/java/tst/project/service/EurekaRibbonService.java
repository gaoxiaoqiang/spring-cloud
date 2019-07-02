package tst.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class EurekaRibbonService {
	
	 @Autowired
	 RestTemplate restTemplate;
	 
	 
	 @HystrixCommand(fallbackMethod = "getInfoFailure")
	 public String getInfo() {
		 String message;
		 try {
	            System.out.println("调用 服务 EUREKA-provider/info");
	            message = restTemplate.getForObject("http://eureka-order/info", String.class);
	            System.out.println("服务 EUREKA-CLIENT/info 返回信息 : " + message);
	            System.out.println("调用 服务EUREKA-provider/info 成功！");
	        } catch (Exception ex) {
	            message = ex.getMessage();
	        }
		 return message;
	 }
	 
	 public String getInfoFailure() {
	        String message = "网络繁忙，请稍后再试-_-。PS：服务消费者自己提供的信息";
	        return message;
	    }
	 
	 
	 

}
