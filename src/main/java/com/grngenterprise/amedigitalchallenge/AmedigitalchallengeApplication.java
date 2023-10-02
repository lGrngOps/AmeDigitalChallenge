package com.grngenterprise.amedigitalchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AmedigitalchallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmedigitalchallengeApplication.class, args);
	}

}
