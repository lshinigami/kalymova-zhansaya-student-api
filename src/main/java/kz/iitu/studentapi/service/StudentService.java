package kz.iitu.studentapi.service;

import kz.iitu.studentapi.model.Student;
import kz.iitu.studentapi.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> findAll() {
        return repository.findAll();
    }

    public Student findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Student create(Student student) {
        student.setId(null);
        return repository.save(student);
    }

    public Student update(Long id, Student student) {
        // TODO: no existence check - a missing id silently creates a new record
        student.setId(id);
        return repository.save(student);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
