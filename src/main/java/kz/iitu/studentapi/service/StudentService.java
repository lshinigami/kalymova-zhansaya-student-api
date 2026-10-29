package kz.iitu.studentapi.service;

import kz.iitu.studentapi.model.Student;
import kz.iitu.studentapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

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
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Student create(Student student) {
        student.setId(null);
        return repository.save(student);
    }

    // Improved UPDATE (Zhansaya Kalymova): check that the student exists
    // and change only its fields instead of silently creating a new record.
    public Student update(Long id, Student changes) {
        Student existing = findById(id);
        existing.setFirstName(changes.getFirstName());
        existing.setLastName(changes.getLastName());
        existing.setEmail(changes.getEmail());
        existing.setGroupName(changes.getGroupName());
        return repository.save(existing);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new StudentNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
