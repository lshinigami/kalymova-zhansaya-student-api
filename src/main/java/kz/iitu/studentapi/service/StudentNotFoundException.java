package kz.iitu.studentapi.service;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super("Student with id " + id + " not found");
    }
}
