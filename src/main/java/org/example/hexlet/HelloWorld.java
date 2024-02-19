package org.example.hexlet;


import io.javalin.validation.ValidationException;
import org.apache.commons.lang3.StringUtils;

import io.javalin.Javalin;

import java.util.Collections;
import java.util.List;

import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.model.courses.*;
import org.example.hexlet.model.users.User;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.model.users.UsersRepository;
import org.example.hexlet.dto.users.UsersPage;

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

// COURSES
        app.get("/courses/build", ctx -> {
            var page = new BuildCoursePage();
            ctx.render("courses/build.jte", Collections.singletonMap("page", page));
        });

        app.post("/courses", ctx -> {
            try {

                var name = ctx.formParamAsClass("name", String.class)
                        .check(value -> value.length() > 2, "У названия недостаточная длина")
                        .get();
                var description = ctx.formParamAsClass("description", String.class)
                        .check(value -> value.length() > 10, "У описания недостаточная длина")
                        .get();

                var course = new Course(name, description);
                CoursesRepository.save(course);
                ctx.redirect("/courses");

            } catch (ValidationException e) {
                var page = new BuildCoursePage(e.getErrors());
                ctx.render("courses/build.jte", Collections.singletonMap("page", page));
            }
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

        // USERS


        app.get("/users/build", ctx -> {
            var page = new BuildUserPage();
            ctx.render("users/build.jte", Collections.singletonMap("page", page));
        });


        app.post("/users", ctx -> {
            var name = ctx.formParam("name").trim();;
            var email = ctx.formParam("email").trim().toLowerCase();

            try {
                var passwordConfirmation = ctx.formParam("passwordConfirmation");
                var password = ctx.formParamAsClass("password", String.class)
                        .check(value -> value.equals(passwordConfirmation), "Пароли не совпадают")
                        .check(value -> value.length() > 2, "У пароля недостаточная длина")
                        .get();
                var user = new User(name, email, password);
                UsersRepository.save(user);
                ctx.redirect("/users");
            } catch (ValidationException e) {
                var page = new BuildUserPage(name, email, e.getErrors());
                ctx.render("users/build.jte", Collections.singletonMap("page", page));
            }
        });

        app.get("/users", ctx -> {
            var term = ctx.queryParam("term");
            List<User> users;

            if (term != null) {
                users = UsersRepository.search(term);
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




