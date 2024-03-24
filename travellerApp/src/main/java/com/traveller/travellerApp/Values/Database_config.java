package com.traveller.travellerApp.Values;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-config.properties")
public class Database_config {
    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    // @Value("${spring.datasource.username}")
    @Value("${spring.datasource.username}")
    private String datasourceUsername;

    @Value("${spring.datasource.password}")
    private String datasourcePassword;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String hibernateDdlAuto;

    // Getter methods for accessing the properties
    public String getDatasourceUrl() {
        return datasourceUrl;
    }

    public String getDatasourceUsername() {
        return datasourceUsername;
    }

    public String getDatasourcePassword() {
        return datasourcePassword;
    }

    public String getHibernateDdlAuto() {
        return hibernateDdlAuto;
    }
}
