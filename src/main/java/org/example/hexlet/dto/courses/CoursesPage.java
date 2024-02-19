package org.example.hexlet.dto.courses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.hexlet.model.courses.Course;

@Getter
@AllArgsConstructor
public class CoursesPage {
    public List<Course> courses;
    public String term;

}