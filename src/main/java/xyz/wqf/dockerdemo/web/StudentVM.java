package xyz.wqf.dockerdemo.web;

import xyz.wqf.dockerdemo.domain.Student;

public class StudentVM extends Student{
    public Student transfrom(){
        Student student = new Student();
        student.setId(getId());
        student.setName(getName());
        student.setAge(getAge());
        return student;
    }
}
