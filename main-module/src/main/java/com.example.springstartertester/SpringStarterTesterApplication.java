package com.example.springstartertester;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class SpringStarterTesterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringStarterTesterApplication.class, args);
        log.info("====================spring boot star==================");
    }

}
