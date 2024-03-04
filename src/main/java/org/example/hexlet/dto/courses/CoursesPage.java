package org.example.hexlet.dto.courses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.hexlet.dto.BasePage;
import org.example.hexlet.model.courses.Course;

@Getter
@AllArgsConstructor
public class CoursesPage extends BasePage {
    public List<Course> courses;
    public String term;

}