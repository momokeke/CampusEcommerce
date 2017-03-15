package com.seu.dm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.seu.dm.mappers","com.seu.dm.interceptors"})
public class CampusEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampusEcommerceApplication.class, args);
	}
}
