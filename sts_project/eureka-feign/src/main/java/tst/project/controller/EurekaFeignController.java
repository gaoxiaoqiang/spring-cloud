package tst.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tst.project.service.EurekaFeignService;

@RestController
public class EurekaFeignController {
	
	@Autowired
	private EurekaFeignService feignService;
	
	
	@RequestMapping("/feignInfo")
	public String feignInfo() {
		String message=feignService.getInfo();
		
		return "feign获取的信息"+message;
	}
	

}
