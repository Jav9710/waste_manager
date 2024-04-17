package com.wastemanager.address.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class OpenApi {

    @Bean
    public OpenAPI customOpenAPI(@Value("2.5.0") String appVersion) {
        return new OpenAPI().info(new Info()
                .title("WastaManagerAddress API")
                .version(appVersion)
                .description("This is the service that handle WasteManagerAddress entitys")
                .termsOfService("http://swagger.io/terms/")
                .license(new License().name("Apache 2.0")
                        .url("http://springdoc.org")));
    }

}
