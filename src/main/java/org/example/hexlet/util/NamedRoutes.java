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

    public static String sessionsPath() {
        return "/sessions";
    }
    
}
