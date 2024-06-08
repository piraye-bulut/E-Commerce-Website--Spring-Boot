package net.code.java;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Controller
public class DatabaseController {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/codejavadb2";
    private static final String DB_USERNAME = "localhost";
    private static final String DB_PASSWORD = "password";

    @GetMapping("/connect")
    @ResponseBody
    public String connectToDatabase() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            if (connection != null) {
                return "Connection to database successful";
            } else {
                return "Error connecting to database";
            }
        } catch (SQLException e) {
            return "Error connecting to database: " + e.getMessage();
        }
    }
}
