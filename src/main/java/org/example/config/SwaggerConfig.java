package org.example.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * openapi 3 (swagger) configuration.
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI velsOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("vels onboarding platform api")
                        .version("1.0.0")
                        .description("rest api for employee onboarding"));
    }
}