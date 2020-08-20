package com.sv.restapi.lab1.dao;

import com.sv.restapi.lab1.entity.Course;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class CourseDAO {
    private static final String SQL_INSERT = "INSERT INTO course (username, description) VALUES (?,?)";
    private static final String SQL_SELECT = "SELECT * FROM course where username=?";
    //private static List<Course> courses = new ArrayList<>();
    private List<Course> courses=null;
    private CourseDAO() {
    }

    public void addCourse(Course course){
        {

            try (Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres", "tiger");
                 PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

                preparedStatement.setString(1, course.getUsername());
                preparedStatement.setString(2, course.getDescription());

                int row = preparedStatement.executeUpdate();

                // rows affected
                //System.out.println(row); // 1t

            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public List<Course> getCourses(String uname){
        courses = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres", "postgres", "tiger");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
             preparedStatement.setString(1, uname);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                long id = resultSet.getLong("id");
                String username = resultSet.getString("username");
                String description = resultSet.getString("description");


                Course obj = new Course();
                obj.setId(id);
                obj.setUsername(username);
                obj.setDescription(description);
                courses.add(obj);
                System.out.println(obj);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
       return courses;
    }

}
