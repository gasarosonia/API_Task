package com.example.studentAPI.Service;
import com.example.studentAPI.Repository.StudentRepo;
import com.example.studentAPI.Model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service

public class StudentService {
    @Autowired
    private StudentRepo studentRepository;

    public Student createStudent(Student student) {
        if (studentRepository.existsByUsername(student.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        return studentRepository.save(student);
    }

    public Optional<Student> updateStudent(Long id, Student updatedStudent) {
        return studentRepository.findById(id).map(student -> {
            student.setFirstName(updatedStudent.getFirstName());
            student.setLastName(updatedStudent.getLastName());
            student.setUsername(updatedStudent.getUsername());
            student.setGender(updatedStudent.getGender());
            student.setDateOfBirth(updatedStudent.getDateOfBirth());
            return studentRepository.save(student);
        });
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
