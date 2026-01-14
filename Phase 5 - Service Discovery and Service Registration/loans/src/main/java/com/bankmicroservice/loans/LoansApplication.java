package com.bankmicroservice.loans;

import com.bankmicroservice.loans.dto.LoansContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@EnableJpaRepositories("com.bankmicroservice.loans.repository")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {LoansContactInfoDto.class})
@OpenAPIDefinition(
        info = @Info(
                title = "Loans microservice REST API Documentation",
                description = "Microservice Bank Loans microservice REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Xeyrus",
                        email = "xeyrus@com",
                        url = "xyz.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "xyz.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Microservice Bank Loans microservice REST API Documentation",
                url = "xyz.com"
        )
)
public class LoansApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoansApplication.class, args);
    }

}
