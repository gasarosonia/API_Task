package com.example.studentAPI.Repository;
import com.example.studentAPI.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    boolean existsByUsername(String username);
}
