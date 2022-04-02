package br.com.tech4tenis.tech4tenis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Tech4tenisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tech4tenisApplication.class, args);
	}

}
