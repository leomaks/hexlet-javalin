package org.example.hexlet;


import org.apache.commons.lang3.StringUtils;

import io.javalin.Javalin;

import java.util.Collections;
import java.util.List;

import org.example.hexlet.model.courses.*;
import org.example.hexlet.model.users.User;
import org.example.hexlet.model.users.UserPage;
import org.example.hexlet.model.users.UsersRepository;
import org.example.hexlet.model.users.UsersPage;

public class HelloWorld {
    public static void main(String[] args) {

        Data.getAllCourses().stream()
                .forEach(course -> CoursesRepository.save(course));

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        app.get("/", ctx -> {
            ctx.render("layout/page.jte");
        });


        app.get("/courses/build", ctx -> {
            ctx.render("courses/build.jte");
        });


        app.post("/courses", ctx -> {
            var name = ctx.formParam("name").trim();;
            var description = ctx.formParam("description");

            var course = new Course(name, description);
            CoursesRepository.save(course);
            ctx.redirect("/courses");
        });



        app.get("/courses", ctx -> {
            var term = ctx.queryParam("term");
            List<Course> courses;

            if (term != null) {
                courses = CoursesRepository.search(term);
            } else {
                courses = CoursesRepository.getEntities();
            }

            var page = new CoursesPage(courses, term);
            ctx.render("courses/courses.jte", Collections.singletonMap("page", page));

        });

        app.get("/courses/{id}", ctx -> {
            var id = ctx.pathParam("id");
            var course = CoursesRepository.find(Long.valueOf(id)).get();
            var page = new CoursePage(course);

            ctx.render("courses/index.jte", Collections.singletonMap("page", page));
        });


       /* app.get("/users/{id}", ctx -> {
            var id = ctx.pathParam("id");
            var escapedId = StringEscapeUtils.escapeHtml4(id);
            ctx.contentType("text/html");
            ctx.result(escapedId);
        });

        */


        app.get("/users/build", ctx -> {
            ctx.render("users/build.jte");
        });

        app.post("/users", ctx -> {
            var name = ctx.formParam("name").trim();;
            var email = ctx.formParam("email").trim().toLowerCase();
            var password = ctx.formParam("password");
            var passwordConfirmation = ctx.formParam("passwordConfirmation");

            var user = new User(name, email, password);
            UsersRepository.save(user);
            ctx.redirect("/users");
        });


        app.get("/users", ctx -> {
            var term = ctx.queryParam("term");
            List<User> users;

            if (term != null) {
                users = UsersRepository.getEntities().stream()
                        .filter(c -> StringUtils.startsWithIgnoreCase(c.getName(), term))
                        .toList();
            } else {
                users = UsersRepository.getEntities();
            }

            var page = new UsersPage(users, term);
            ctx.render("users/users.jte", Collections.singletonMap("page", page));

        });


        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParam("id");
            var user = UsersRepository.find(Long.valueOf(id));
            var page = new UserPage(user.get());

            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        });

         /* app.get("/hello", ctx -> {

            ctx.result("Hello, "
                    +  ctx.queryParamAsClass("name", String.class).getOrDefault("World")
                    + "!");
        });*/

        app.start(7070);
    }


}




