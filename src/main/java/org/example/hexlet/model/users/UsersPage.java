package org.example.hexlet.model.users;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor

public class UsersPage {
    public List<User> users;
    public String term;
}

