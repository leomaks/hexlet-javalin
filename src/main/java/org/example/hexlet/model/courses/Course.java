package org.example.hexlet.model.courses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class Course {
    private Long id;
    private String name;
    private String description;

    public Course(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }

}