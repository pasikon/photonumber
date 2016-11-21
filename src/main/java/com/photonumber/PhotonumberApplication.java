package com.photonumber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@SpringBootApplication
public class PhotonumberApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotonumberApplication.class, args);
	}
}
