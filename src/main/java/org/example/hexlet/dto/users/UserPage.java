package org.example.hexlet.dto.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.hexlet.model.users.User;


@Getter
@AllArgsConstructor

public class UserPage {
    private User user;
}
