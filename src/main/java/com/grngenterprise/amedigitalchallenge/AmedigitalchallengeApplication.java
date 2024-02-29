package com.grngenterprise.amedigitalchallenge;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "AmeDigital API Desafio", version = "1.0", description = "Desafio AmeDigital - Doc via Swagger"))
public class AmedigitalchallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmedigitalchallengeApplication.class, args);
	}

}
