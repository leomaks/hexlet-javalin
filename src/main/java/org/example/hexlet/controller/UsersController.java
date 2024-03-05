package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.users.User;
import org.example.hexlet.repositories.UsersRepository;


import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class UsersController {
    public static void build(Context ctx) {
            var page = new BuildUserPage();

            ctx.render("users/build.jte", Collections.singletonMap("page", page));
    }

    public static void create (Context ctx) throws SQLException {
        var name = ctx.formParam("name").trim();
        var email = ctx.formParam("email").trim().toLowerCase();


        try {
            var passwordConfirmation = ctx.formParam("passwordConfirmation");
            var password = ctx.formParamAsClass("password", String.class)
                    .check(value -> value.equals(passwordConfirmation), "Пароли не совпадают")
                    .check(value -> value.length() > 2, "У пароля недостаточная длина")
                    .get();
            var user = new User(name, email, password);
            UsersRepository.save(user);
            ctx.sessionAttribute("flash", "User has been created!");
            ctx.redirect("/users");
        } catch (ValidationException e) {
            var page = new BuildUserPage(name, email, e.getErrors());
            ctx.sessionAttribute("flash", "Error, the item was not created");
            page.setFlash(ctx.consumeSessionAttribute("flash"));
            ctx.render("users/build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void index (Context ctx) throws SQLException {
        var term = ctx.queryParam("term");
        List<User> users;

        if (term != null) {
            users = UsersRepository.search(term);
        } else {
            users = UsersRepository.getEntities();
        }

        var page = new UsersPage(users, term);
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        ctx.render("users/users.jte", Collections.singletonMap("page", page));

    }

    public static void show (Context ctx) throws SQLException {
        var id = ctx.pathParam("id");
        var user = UsersRepository.find(Long.valueOf(id));
        var page = new UserPage(user.get());

        ctx.render("users/index.jte", Collections.singletonMap("page", page));
    }
}
