package com.traveller.travellerApp;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import ch.qos.logback.classic.Logger;

@SpringBootApplication

public class TravellerAppApplication {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(TravellerAppApplication.class);

	public static void main(String[] args) {
		log.info("this is a info message");
		log.warn("this is a warn message");
		log.error("this is a error message");
		SpringApplication.run(TravellerAppApplication.class, args);

	}

}
