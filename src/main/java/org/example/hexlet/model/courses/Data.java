package org.example.hexlet.model.courses;

import java.util.ArrayList;


public class Data {
    private static final int ITEMS_COUNT = 30;
    public static Course getCourse(Long id) {
        Course course = new Course(id, "course number: " + id, "description: " + id);
        return course;
    }

    public static ArrayList<Course> getAllCourses() {

        ArrayList<Course> courses = new ArrayList<>();

        for (int i = 0; i < ITEMS_COUNT; i++) {
            Course course = new Course((long) i, "course number: " + i, "description: " + i);
            courses.add(course);
        }


        Course course = new Course((long) 31, "PHP", "something about php");
        courses.add(course);

        Course course1 = new Course((long) 32, "java", "something about java");
        courses.add(course1);

        return courses;
    }

}
