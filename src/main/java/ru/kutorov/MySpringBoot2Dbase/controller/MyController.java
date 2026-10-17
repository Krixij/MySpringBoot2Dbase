package ru.kutorov.MySpringBoot2Dbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kutorov.MySpringBoot2Dbase.entity.Student;
import ru.kutorov.MySpringBoot2Dbase.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> allStudent(){
        List<Student> allStudents = studentService.getAllStudents();
        return ResponseEntity.ok(allStudents);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int id){
        Student student = studentService.getStudent(id);

        if (student == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(student);
        }
    }

    @PostMapping("/students")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        Student savedStudent = studentService.saveStudent(student);
        return ResponseEntity.status(201).body(savedStudent);
    }

    @PutMapping("/students")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        Student foundStudent = studentService.getStudent(student.getId());
        if (foundStudent != null) {
            return ResponseEntity.ok(studentService.saveStudent(student));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id){
        boolean isDelete = studentService.deleteStudent(id);
        if (isDelete) {
            return ResponseEntity.ok("Студент успешно удален с id: " + id);
        } else {
            return ResponseEntity.status(404).body("Студент с id: " + id + " не найден");
        }
    }
}
