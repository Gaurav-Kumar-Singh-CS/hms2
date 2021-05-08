package com.gaurav.roommanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RoomManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomManagementApplication.class, args);
	}

}
