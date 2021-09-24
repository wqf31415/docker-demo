package xyz.wqf.dockerdemo.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.wqf.dockerdemo.domain.Student;
import xyz.wqf.dockerdemo.repository.StudentRepository;
import xyz.wqf.dockerdemo.web.StudentVM;

import java.util.List;

@RestController
public class StudentResource {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student findOne(@PathVariable(name = "id") Long id){
        return studentRepository.findById(id).orElse(null);
    }

    @PostMapping("/students")
    public Student createOne(StudentVM student){
        return studentRepository.save(student.transfrom());
    }

    @PutMapping("/students")
    public Student modifyOne(StudentVM student){
        return studentRepository.save(student.transfrom());
    }

    @DeleteMapping("/students/{id}")
    public void deleteOne(@PathVariable Long id){
        studentRepository.deleteById(id);
    }
}
