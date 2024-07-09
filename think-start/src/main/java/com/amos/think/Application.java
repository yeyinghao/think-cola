package com.amos.think;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot Starter
 *
 * @author Frank Zhang
 */
@EnableScheduling
@SpringBootApplication(scanBasePackages = {"com.amos.think", "com.alibaba.cola"})
@MapperScan("com.amos.think.user.gateway.impl.database.mapper")
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/")
	public String start() {
		return "Hello, welcome to COLA world!";
	}

}
