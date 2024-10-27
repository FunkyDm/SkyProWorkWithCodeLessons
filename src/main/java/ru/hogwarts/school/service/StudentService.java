package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    Student readStudent(Long id);
    Student editStudent(Long id, Student student);
    Student deleteStudent(Long id);

    List<Student> filterByAge(int age);

    List<Student> findAllByAgeBetween(int fromAge, int toAge);
    //private final HashMap<Long, Student> studentHashMap = new HashMap<Long, Student>();
    Faculty getFaculty(Long studentId);
}