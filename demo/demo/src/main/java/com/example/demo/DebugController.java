package com.example.demo.controllers;  // or your package

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
public class DebugController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/dbinfo")
    public String getDbInfo() {
        try (Connection conn = dataSource.getConnection()) {
            String url = conn.getMetaData().getURL();
            String catalog = conn.getCatalog();
            return "URL: " + url + ", Catalog/Schema: " + catalog;
        } catch (SQLException e) {
            return "Error fetching DB info: " + e.getMessage();
        }
    }
}