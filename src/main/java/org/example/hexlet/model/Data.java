package org.example.hexlet.model;

import java.util.List;
import java.util.ArrayList;


public class Data {
    private static final int ITEMS_COUNT = 30;
    public static Course getCourse(Long id) {
        Course course = new Course(id, "course number: " + id, "description: " + id);
        return course;
    }

    public static List<Course> getAllCourses() {

        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < ITEMS_COUNT; i++) {
            Course course = new Course((long) i, "course number: " + i, "description: " + i);
            courses.add(course);
        }
        return courses;
    }

}
