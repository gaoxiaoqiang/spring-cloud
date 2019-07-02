package tst.project.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import tst.project.config.EurekaFeignServiceFailure;


//eureka-provider为注册的服务
@FeignClient(value="eureka-member",fallback = EurekaFeignServiceFailure.class)
public interface EurekaFeignService {
	
	@RequestMapping(value="/info")
	String getInfo();
	
	

}