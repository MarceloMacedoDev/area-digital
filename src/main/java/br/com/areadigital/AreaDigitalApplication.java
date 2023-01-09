package br.com.areadigital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AreaDigitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(AreaDigitalApplication.class, args);
	}

}
