package com.ga.john.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")

public class StudentController {
    private final StudentService studentService; //reference the StudentService class

    //@Autowired initiates studentService
    @Autowired
    public StudentController(StudentService studentService) {
        //studentService should be injected (autowired into the constructor), studentService is found with @Service annotation
        this.studentService = studentService;  //DI is used instead of "new"
    }

    @GetMapping
    public List<Student> getStudents(){

        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){ //put body into student
        studentService.addNewStudent(student);
    }
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);

    }
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);
    }

}