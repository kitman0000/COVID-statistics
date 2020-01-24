package com.wuhanvirus.wuhanvirus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {"com.wuhanvirus.wuhanvirus.*"})
@EnableScheduling
public class WuhanvirusApplication {

	public static void main(String[] args) {
		SpringApplication.run(WuhanvirusApplication.class, args);
	}

}
