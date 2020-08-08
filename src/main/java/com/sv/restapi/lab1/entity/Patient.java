package com.sv.restapi.lab1.entity;

import java.util.Objects;

public class Patient {
    private Long id;
    private String username;
    private String name;

    public Patient(Long id, String username, String name) {
        this.id = id;
        this.username = username;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String description) {
        this.name = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient course = (Patient) o;
        return getId().equals(course.getId()) &&
                getUsername().equals(course.getUsername()) &&
                getName().equals(course.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getName());
    }
}
