package com.oalchoudhary.price;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PriceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PriceApplication.class, args);
    }

}
