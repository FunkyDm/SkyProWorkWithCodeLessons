package ru.hogwarts.school.service.Impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
//import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.service.FacultyService;

import java.util.List;
@Service
public class FacultyServiceImpl implements FacultyService {


    private FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty createFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
        return faculty;
    }

    @Override
    public Faculty readFaculty(Long id) {
        return facultyRepository.getById(id);
    }


    @Override
    public Faculty editFaculty(Long id, Faculty faculty) {
        //получили факультет  из нашей базы данных
        return facultyRepository.findById(id).map(facultyFromBd -> {
            facultyFromBd.setName(faculty.getName());
            facultyFromBd.setColor(faculty.getColor());
            facultyRepository.save(facultyFromBd);
            return facultyFromBd;
        }).orElse(null);
    }

    @Override
    public Faculty deleteFaculty(Long id) {
        return facultyRepository.findById(id).map(faculty -> {
            facultyRepository.deleteById(id);
            return faculty;
        }).orElse(null);
    }

    @Override
    public List<Faculty> filterByColor(String color) {
        return facultyRepository.findAllByColor(color);
    }

    @Override
    public List<Faculty> findAllByNameIgnoreCaseOrColorIgnoreCase(String name, String color) {
        return facultyRepository.findAllByNameIgnoreCaseOrColorIgnoreCase(name, color);
    }

    @Override
    public List<Student> getStudents(Long facultyId) {
        return facultyRepository.findById(facultyId)
                .map(Faculty::getStudents)
                .orElse(null);
    }
}
