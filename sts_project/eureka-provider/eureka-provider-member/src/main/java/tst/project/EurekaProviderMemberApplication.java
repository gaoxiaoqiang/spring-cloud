package tst.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaProviderMemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaProviderMemberApplication.class, args);
	}

}