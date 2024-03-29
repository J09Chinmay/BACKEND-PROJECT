package com.traveller.travellerApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.traveller.travellerApp.Values.Database_config;

import jakarta.annotation.PreDestroy;

// import jakarta.annotation.PreDestroy;

@SpringBootApplication
@EnableConfigurationProperties

public class TravellerAppApplication {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(TravellerAppApplication.class);
	// @Autowired
	private Database_config appConfig;

	@Autowired
	public TravellerAppApplication(Database_config appConfig) {
		this.appConfig = appConfig;
	}

	public static void main(String[] args) {

		log.info("this is a info message");
		log.warn("this is a warn message");
		log.error("this is a error message");
		SpringApplication.run(TravellerAppApplication.class, args);

	}

	public Connection connection;

	@Autowired
	public Connection connect() {
		try {
			String url = appConfig.getDatasourceUrl();
			String user = appConfig.getDatasourceUsername();
			String password = appConfig.getDatasourcePassword();

			log.info("Connected to PostgreSQL database Done.............");
			return connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			log.error("Failed to connect to PostgreSQL database: " + e.getMessage());
		}
		return null;
	}

	@PreDestroy
	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
				log.info("Connection to PostgreSQL database closed.");
			} catch (SQLException e) {
				log.info("Failed to close connection: " + e.getMessage());
			}
		} else {
			log.info("Connection is already closed.");
		}
	}

}
