package com.bankmicroservice.cards;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Cards microservice REST API Documentation",
				description = "Microservice Bank Cards microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Xeyrus",
						email = "xyz@com",
						url = "xyz.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "xyz.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Microservice Bank Cards microservice REST API Documentation",
				url = "xyz.com"
		)
)
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
