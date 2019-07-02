package tst.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.netflix.ribbon.proxy.annotation.Hystrix;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
public class EurekaFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaFeignApplication.class, args);
	}

}
