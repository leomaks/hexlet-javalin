package org.example.hexlet.model.courses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class CoursesPage {
    public List<Course> courses;
    public String term;

}