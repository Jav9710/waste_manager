package com.wastemanager.config;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles(profiles = {"dev", "native"})
class ConfigApplicationTests {

    @Test
    void contextLoads() {
    }

}
