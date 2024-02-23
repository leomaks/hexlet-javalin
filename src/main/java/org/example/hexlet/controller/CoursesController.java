package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.courses.Course;
import org.example.hexlet.model.courses.CoursesRepository;
import org.example.hexlet.util.NamedRoutes;

import java.util.Collections;
import java.util.List;

public class CoursesController {
    public static  void index(Context ctx) {
        var term = ctx.queryParam("term");
        List<Course> courses;

        if (term != null) {
            courses = CoursesRepository.search(term);
        } else {
            courses = CoursesRepository.getEntities();
        }

        var page = new CoursesPage(courses, term);
        ctx.render("courses/courses.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildCoursePage();
        ctx.render("courses/build.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParam("id");
        var course = CoursesRepository.find(Long.valueOf(id)).get();
        var page = new CoursePage(course);
        ctx.render("courses/index.jte", Collections.singletonMap("page", page));
    }
    public  static void create(Context ctx) {
        try {

            var name = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() > 2, "У названия недостаточная длина")
                    .get();
            var description = ctx.formParamAsClass("description", String.class)
                    .check(value -> value.length() > 10, "У описания недостаточная длина")
                    .get();

            var course = new Course(name, description);
            CoursesRepository.save(course);
            ctx.redirect(NamedRoutes.coursesPath());

        } catch (ValidationException e) {
            var page = new BuildCoursePage(e.getErrors());
            ctx.render("courses/build.jte", Collections.singletonMap("page", page));
        }
    }
}