package org.example.hexlet.util;

public class NamedRoutes {

    public static String coursesPath() {
        return "/courses";
    }

    public static String coursePath(String id) {
        return "/courses/" + id;
    }
    public static String buildCoursePath() {
        return "/courses/build";
    }
    public static String buildUserPath() {
        return "/users/build";
    }

    public static String usersPath() {
        return "/users";
    }

    public static String userPath(String id) {
        return "/users/" + id;
    }

/*
"/users/build"

"/courses/{id}"
"/courses/build"


    public static String buildUserPath() {
        return "/users/build";
    }

    public static String coursesPath() {
        return "/courses";
    }

    // Это нужно, чтобы не преобразовывать типы снаружи
    public static String coursePath(Long id) {
        return coursePath(String.valueOf(id));
    }



 */
}
