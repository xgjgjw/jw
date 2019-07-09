package com.mj.jw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableCaching
@PropertySource({"classpath:logback.properties","classpath:db.properties"})
public class JwApplication {
    public static void main(String[] args) {
        SpringApplication.run(JwApplication.class, args);
    }

}
