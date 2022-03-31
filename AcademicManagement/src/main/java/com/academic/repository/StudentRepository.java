package com.academic.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.academic.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
