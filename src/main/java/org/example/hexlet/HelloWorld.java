package org.example.hexlet;

import io.javalin.Javalin;


import io.javalin.Javalin;
import java.util.Collections;

import io.javalin.http.Context;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.CoursePage;
import org.example.hexlet.model.CoursesPage;
import org.example.hexlet.model.Data;
import org.jetbrains.annotations.NotNull;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        // Описываем, что загрузится по адресу /

        //app.get("/", ctx -> ctx.render("index.jte"));
        

        app.get("/courses", ctx -> {

            var header = "Курсы по программированию";
            var courses = Data.getAllCourses();
            var page = new CoursesPage(courses, header);

            ctx.render("courses.jte", Collections.singletonMap("page", page));
        });

        app.get("/courses/{id}", ctx -> {
            var id = ctx.pathParam("id");
            var course = Data.getCourse(Long.getLong(id));
            var page = new CoursePage(course);

            ctx.render("index.jte", Collections.singletonMap("page", page));
        });


         /* app.get("/hello", ctx -> {

            ctx.result("Hello, "
                    +  ctx.queryParamAsClass("name", String.class).getOrDefault("World")
                    + "!");
        });*/

        app.start(7070);
    }


}




