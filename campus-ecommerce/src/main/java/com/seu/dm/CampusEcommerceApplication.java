package com.seu.dm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.seu.dm.mappers")
public class CampusEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampusEcommerceApplication.class, args);
	}
}
