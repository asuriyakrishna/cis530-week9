package edu.bellevue.cis530.studentprofileservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StudentProfileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentProfileServiceApplication.class, args);
	}

}
