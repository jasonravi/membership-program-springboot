package com.firstclub.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.*;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI membershipApi() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title(
                                        "Membership API"
                                )
                                .version("1.0")
                                .description(
                                        "FirstClub Membership System"
                                )
                );
    }
}