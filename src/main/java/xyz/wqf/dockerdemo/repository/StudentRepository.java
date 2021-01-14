package xyz.wqf.dockerdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.wqf.dockerdemo.domain.Student;

/**
 * Created by Administrator on 2021/1/14.
 *
 * @author WeiQuanfu
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
