package tst.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
public class EurekaFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaFeignApplication.class, args);
	}

}
