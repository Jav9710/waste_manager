package com.wastemanager.wastemanageraddressservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan("com.wastemanager.model")
public class WasteManagerAddressServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WasteManagerAddressServiceApplication.class, args);
    }

}
