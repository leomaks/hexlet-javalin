package org.example.hexlet.model;


public class CoursePage {
    private Course course;

    public String getName() {
        return course.getName();
    }
    public String getDescription() {
        return course.getDescription();
    }

    public CoursePage(Course course) {
        this.course = course;
    }
}