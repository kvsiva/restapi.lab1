package com.sv.restapi.lab1;

import com.sv.restapi.lab1.entity.Course;

import java.math.BigDecimal;
import java.sql.*;

public class getCourses {
    private static final String SQL_SELECT = "SELECT * FROM course";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/test", "postgres", "password");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                long id = resultSet.getLong("id");
                String username = resultSet.getString("username");
                String description = resultSet.getString("description");


                Course obj = new Course();
                obj.setId(id);
                obj.setUsername(username);
                obj.setDescription(description);
                System.out.println(obj);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
