package xyz.wqf.dockerdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.wqf.dockerdemo.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
