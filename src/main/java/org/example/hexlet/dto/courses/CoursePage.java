package org.example.hexlet.dto.courses;


import org.example.hexlet.model.courses.Course;

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