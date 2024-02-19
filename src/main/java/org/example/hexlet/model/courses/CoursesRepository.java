package org.example.hexlet.model.courses;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CoursesRepository {
    private static List<Course> entities = new ArrayList<Course>();
    public static void save(Course course) {
        course.setId((long) entities.size() + 1);
        entities.add(course);
    }

    public static List<Course> search(String term) {
        var courses = entities.stream()
                .filter(entity -> entity.getName().startsWith(term))
                .toList();
        return courses;
    }
    public static Optional<Course> find(Long id) {
        var course = entities.stream()
                .filter(entity -> entity.getId().equals(id))
                .findAny();
        return course;
    }
    public static List<Course> getEntities() {
        return entities;
    }
}
