package ru.kutorov.MySpringBoot2Dbase.service;

import org.springframework.stereotype.Service;
import ru.kutorov.MySpringBoot2Dbase.entity.Student;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudent(int id);
    boolean deleteStudent(int id);
}
