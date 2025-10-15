package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;
import java.net.URI;

@Configuration
public class DatabaseConfig {

    @Value("${JAWSDB_MARIA_URL:}")
    private String jawsdbUrl;

    @Bean
    public DataSource dataSource() throws Exception {
        if (jawsdbUrl == null || jawsdbUrl.isEmpty()) {
            // fallback to local dev application.properties
            return DataSourceBuilder.create().build();
        }

        URI dbUri = new URI(jawsdbUrl);

        String[] userInfo = dbUri.getUserInfo().split(":");
        String username = userInfo[0];
        String password = userInfo[1];

        String jdbcUrl = "jdbc:mariadb://" + dbUri.getHost() + ":" + dbUri.getPort() + dbUri.getPath();

        return DataSourceBuilder.create()
                .url(jdbcUrl)
                .username(username)
                .password(password)
                .driverClassName("org.mariadb.jdbc.Driver")
                .build();
    }
}