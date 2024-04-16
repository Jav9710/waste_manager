package com.wastemanager.address;

import com.wastemanager.exceptions.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan(basePackages = {"com.wastemanager.model", "com.wastemanager.dto"})
@Import({ExceptionHandler.class})
//@ComponentScan(basePackages = {"com.wastemanager.exceptions"})
public class WasteManagerAddressServiceApplication {
    private static final Logger LOG = LoggerFactory.getLogger(WasteManagerAddressServiceApplication.class);
    public static void main(String[] args) throws UnknownHostException  {
        SpringApplication app = new SpringApplication(WasteManagerAddressServiceApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\thttp://127.0.0.1:{}\n\t" +
                        "External: \thttp://{}:{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name", "service-gateway"),
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostName(),
                env.getProperty("server.port"));
    }
}
