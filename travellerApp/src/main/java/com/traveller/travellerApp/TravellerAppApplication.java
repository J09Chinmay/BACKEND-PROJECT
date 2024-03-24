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

@SpringBootApplication
@EnableConfigurationProperties

public class TravellerAppApplication {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(TravellerAppApplication.class);
	private final Database_config appConfig;

	@Autowired
	public TravellerAppApplication(Database_config appConfig) {
		this.appConfig = appConfig;
	}

	public Connection connection;

	// public Connection connect() throws SQLException {
	// String url = appConfig.getDatasourceUrl();
	// String user = appConfig.getDatasourceUsername();
	// String password = appConfig.getDatasourcePassword();

	// return DriverManager.getConnection(url, user, password);
	// }
	@Autowired
	public void connect() {
		try {
			String url = appConfig.getDatasourceUrl();
			String user = appConfig.getDatasourceUsername();
			String password = appConfig.getDatasourcePassword();
			// Establish connection

			log.info("Connected to PostgreSQL database Done.");
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			log.error("Failed to connect to PostgreSQL database: " + e.getMessage());
		}
		// return null;
	}

	public static void main(String[] args) {

		log.info("this is a info message");
		log.warn("this is a warn message");
		log.error("this is a error message");
		// TravellerAppApplication app = new TravellerAppApplication();
		// app.connect();

		SpringApplication.run(TravellerAppApplication.class, args);

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

// public Connection connect() throws SQLException {
// return DriverManager.getConnection(url, user, password);
// }
// private final String url = "jdbc:postgresql://localhost/postgres";
// private final String user = "postgres";
// private final String password = "chinmay09";