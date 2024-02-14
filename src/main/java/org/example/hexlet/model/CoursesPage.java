package org.example.hexlet.model;

import java.util.List;

public class CoursesPage {
    public CoursesPage(List<Course> courses, String header) {
        this.courses = courses;
        this.header = header;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getHeader() {
        return header;
    }

    private List<Course> courses;
    private String header;
}