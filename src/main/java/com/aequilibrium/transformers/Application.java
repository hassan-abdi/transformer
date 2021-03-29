package com.aequilibrium.transformers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = "com.aequilibrium.transformers")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
