package com.wastemanager.address.config;

import feign.Contract;
import feign.RequestInterceptor;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;

public class FeignClientConfig {
    @Bean
    public Contract feignContract() {
        return new SpringMvcContract();
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("Accept", "application/json");
        };
    }
}
