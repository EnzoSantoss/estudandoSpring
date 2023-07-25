package com.meuProjeto.enzoSpring.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {


    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
    this.studentService = studentService;
    }

    @GetMapping
    public List<Student> students(){
        return this.studentService.getStudentList();
    }

    @PostMapping
    public String createNewStudent(@RequestBody Student student){

        try{
            this.studentService.createStudent(student);
            return "Usuario Criado";
        }catch (Exception e){
            e.printStackTrace();
            return "falha ao cadastrar um usuario";
        }

    }

}
