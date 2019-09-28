package com.manager.student.service;
import com.manager.student.entity.Student;
import com.manager.student.reponsitory.StudentReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Calendar;
import java.util.Optional;

public class StudentServiceImplement implements StudentService{
    @Autowired
    private StudentReponsitory studentReponsitory;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Page<Student> getList(int page, int limit) {
        return studentReponsitory.findAll(-1, limit);
    }

    @Override
    public Student getDetail(int id) {
        return studentReponsitory.findById(id).orElse(null);
    }

    @Override
    public Student login(String email, String password) {
        //serach user ===
        Optional<Student> optionalStudent = studentReponsitory.findById(email);
        if (optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            if (student.getPassword().equals(password)){
                return student;
            }
        }
        return null;
    }


    @Override
    public Student register(Student student) {
            student.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentReponsitory.save(student);
    }

    @Override
    public Student update(String email, Student student) {

        Optional<Student> optionalStudent = studentReponsitory.findById(email);
        if (optionalStudent == null){
            Student existStudent = optionalStudent.get();
            existStudent.setName(student.getName());
            existStudent.setPassword(student.getPassword());
            existStudent.setEmail(student.getEmail());
            existStudent.setCodeStudent(student.getCodeStudent());
            return studentReponsitory.save(student);

        }
        return null;
    }

    @Override
    public Student getByEmail(String email) {
        return studentReponsitory.findById(email).orElse(null);
    }
}
