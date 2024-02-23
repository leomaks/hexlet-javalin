package org.example.hexlet;

import io.javalin.Javalin;
import org.example.hexlet.controller.CoursesController;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.model.courses.*;
import org.example.hexlet.util.NamedRoutes;

public class HelloWorld {
    public static void main(String[] args) {

        Data.getAllCourses().stream().forEach(course -> CoursesRepository.save(course));
        var app = Javalin.create(config -> config.plugins.enableDevLogging());
        app.get("/", ctx -> ctx.render("layout/page.jte"));

// COURSES
        app.get(NamedRoutes.coursesPath(), CoursesController::index);
        app.get(NamedRoutes.buildCoursePath(), CoursesController::build);
        app.post(NamedRoutes.coursesPath(), CoursesController::create);
        app.get(NamedRoutes.coursePath("{id}"), CoursesController::show);


 // USERS
        app.get(NamedRoutes.buildUserPath(), UsersController::build);
        app.post(NamedRoutes.usersPath(), UsersController::create);
        app.get(NamedRoutes.usersPath(),UsersController::index);
        app.get(NamedRoutes.userPath("{id}"), UsersController::show);


        app.start(7070);

         /* app.get("/hello", ctx -> {

            ctx.result("Hello, "
                    +  ctx.queryParamAsClass("name", String.class).getOrDefault("World")
                    + "!");
        });*/
               /* app.get("/users/{id}", ctx -> {
            var id = ctx.pathParam("id");
            var escapedId = StringEscapeUtils.escapeHtml4(id);
            ctx.contentType("text/html");
            ctx.result(escapedId);
        });

        */
    }
}




