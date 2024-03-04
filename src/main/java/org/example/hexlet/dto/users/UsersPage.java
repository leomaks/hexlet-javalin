package org.example.hexlet.dto.users;
import java.util.List;

import org.example.hexlet.dto.BasePage;
import org.example.hexlet.model.users.User;
import lombok.AllArgsConstructor;
import lombok.Getter;



@Getter
@AllArgsConstructor

public class UsersPage extends BasePage {
    public List<User> users;
    public String term;
}

