package org.example.hexlet;

import io.javalin.Javalin;
import org.example.hexlet.controller.CoursesController;
import org.example.hexlet.controller.SessionsController;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.dto.MainPage;
import org.example.hexlet.model.courses.*;
import org.example.hexlet.util.NamedRoutes;

import java.util.Collections;

public class HelloWorld {
    public static void main(String[] args) {

        Data.getAllCourses().stream().forEach(course -> CoursesRepository.save(course));
        var app = Javalin.create(config -> config.plugins.enableDevLogging());
    //    app.get("/", ctx -> ctx.render("layout/page.jte"));
        //////////

/*
        app.get("/", ctx -> {
            var visited = Boolean.valueOf(ctx.cookie("visited"));
            var page = new MainPage(visited);
            ctx.render("index.jte", Collections.singletonMap("page", page));
            ctx.cookie("visited", String.valueOf(true));
        });

 */

        app.get("/", ctx -> {
            var page = new MainPage(ctx.sessionAttribute("currentUser"));
            ctx.render("index.jte", Collections.singletonMap("page", page));
        });
        ///
        app.get("/sessions/build", SessionsController::build);
// Процесс логина
        app.post("/sessions", SessionsController::create);
// Процесс выхода из аккаунта
        app.delete("/sessions", SessionsController::destroy);




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




