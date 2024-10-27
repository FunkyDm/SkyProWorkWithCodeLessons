package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.List;

public interface FacultyService {
    Faculty createFaculty(Faculty faculty);
    Faculty readFaculty(Long id);
   Faculty editFaculty(Long id, Faculty faculty);
    Faculty deleteFaculty(Long id);

    List<Faculty> filterByColor(String color);

    List<Faculty> findAllByNameIgnoreCaseOrColorIgnoreCase(String name, String color);

   //List<Student> getStudents(long id);

    List<Student> getStudents(Long facultyId);


}
