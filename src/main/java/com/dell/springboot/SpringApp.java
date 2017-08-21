package com.dell.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.dell.springboot.config.JpaConfiguration;

@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"com.dell.springboot"})
public class SpringApp {
	public static void main(String[] args) {
SpringApplication.run(SpringApp.class, args);
	}
}
