package tst.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tst.project.service.EurekaRibbonService;

@RestController
public class EurekaRibbonController {
	
	@Autowired
	private EurekaRibbonService eurekaFeignService;
	
	@RequestMapping("/ribbonInfo")
	public String feignInfo() {
		
		String message=eurekaFeignService.getInfo();
		
		return "ribbon获取到的信息"+message;
	}

}
