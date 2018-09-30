package com.xulong.amazingsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AmazingSiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmazingSiteApplication.class, args);
    }
}
