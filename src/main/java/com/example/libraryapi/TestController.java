package com.example.libraryapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
public class TestController {

    private final DataSource dataSource;

    public TestController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/db-test")
    public String testDatabase() {
        try (Connection connection = dataSource.getConnection()) {
            return "Database Connected Successfully!";
        } catch (SQLException e) {
            return "Database Connection Failed: " + e.getMessage();
        }
    }
}