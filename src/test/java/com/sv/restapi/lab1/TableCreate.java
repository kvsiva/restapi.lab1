package com.sv.restapi.lab1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreate {

    private static final String SQL_CREATE = "CREATE TABLE course"
            + "("
            + " id serial,"
            + " username varchar(20) NOT NULL,"
            + " description varchar(150) NOT NULL,"
            + " PRIMARY KEY (id)"
            + ")";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://172.17.0.2:5432/postgres", "postgres", "tiger");

             Statement statement = conn.createStatement()) {

            // if DDL failed, it will raise an SQLException
            statement.execute(SQL_CREATE);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}