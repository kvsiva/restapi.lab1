package com.sv.restapi.lab1;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;

public class AddCourse {
    private static final String SQL_INSERT = "INSERT INTO course (username, description) VALUES (?,?)";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres", "postgres", "tiger");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

            preparedStatement.setString(1, "sv");
            preparedStatement.setString(2, "ReactJS");

            int row = preparedStatement.executeUpdate();

            // rows affected
            System.out.println(row); // 1

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
