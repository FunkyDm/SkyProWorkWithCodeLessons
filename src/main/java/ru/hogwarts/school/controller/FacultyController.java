package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
//import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.List;


@RestController
@RequestMapping("faculties")

public class FacultyController {
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    //инжектируем
    private final FacultyService facultyService;


    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @GetMapping("{id}")
    public Faculty readFaculty(@PathVariable long id) {
        return facultyService.readFaculty(id);
    }

    @PutMapping("{id}")
    public Faculty updateFaculty(@PathVariable Long id, @RequestBody Faculty faculty) {
        return facultyService.editFaculty(id, faculty);
    }

    @GetMapping
    public List<Faculty> filterByColor(@RequestParam String color) {
        return facultyService.filterByColor(color);
    }

    @DeleteMapping("{id}")
    public Faculty deleteFaculty(@PathVariable Long id) {
        return facultyService.deleteFaculty(id);
    }

    @GetMapping("byNameOrColorIgnoreCase")
    public List<Faculty> findAllByNameIgnoreCaseOrColorIgnoreCase(@PathVariable String name,
                                                                  @PathVariable String color) {
        return facultyService.findAllByNameIgnoreCaseOrColorIgnoreCase(name, color);

    }

    @GetMapping("{id}/students")
    public List<Student> getStudents(@PathVariable long id) {

        return facultyService.getStudents(id);
    }

}

