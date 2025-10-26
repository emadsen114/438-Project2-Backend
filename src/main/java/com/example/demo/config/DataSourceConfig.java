package com.example.demo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

@Configuration
public class DataSourceConfig {

  /**
   * On Heroku, JawsDB Maria exposes JAWSDB_MARIA_URL like:
   *   mysql://USER:PASS@HOST:PORT/DBNAME
   * We convert that into a proper JDBC URL for MariaDB and set username/password.
   */
  @Bean
  @ConditionalOnProperty(name = "spring.profiles.active", havingValue = "heroku")
  public HikariDataSource herokuDataSource(
      @Value("${JAWSDB_MARIA_URL:}") String jawsUrlEnv) {

    if (jawsUrlEnv == null || jawsUrlEnv.isBlank()) {
      throw new IllegalStateException("JAWSDB_MARIA_URL not set");
    }

    URI uri = URI.create(jawsUrlEnv.replace("mysql://", "http://")); // trick to parse
    String userInfo = uri.getUserInfo();
    if (userInfo == null || !userInfo.contains(":")) {
      throw new IllegalStateException("Invalid JAWSDB_MARIA_URL (missing credentials)");
    }
    String username = userInfo.substring(0, userInfo.indexOf(':'));
    String password = userInfo.substring(userInfo.indexOf(':') + 1);
    String host = uri.getHost();
    int port = (uri.getPort() == -1 ? 3306 : uri.getPort());
    String db = uri.getPath();
    if (db == null || db.length() <= 1) {
      throw new IllegalStateException("Invalid JAWSDB_MARIA_URL (missing database)");
    }
    db = db.substring(1); // strip leading '/'

    String jdbcUrl = "jdbc:mariadb://" + host + ":" + port + "/" + db + "?useUnicode=true&characterEncoding=utf8";

    HikariDataSource ds = new HikariDataSource();
    ds.setJdbcUrl(jdbcUrl);
    ds.setUsername(username);
    ds.setPassword(password);
    ds.setMaximumPoolSize(5);
    ds.setMinimumIdle(1);
    return ds;
  }
}
