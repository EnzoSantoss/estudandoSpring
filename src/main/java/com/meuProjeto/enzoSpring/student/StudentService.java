package com.meuProjeto.enzoSpring.student;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudentList(){

        List<Student> studentsList = List.of(new Student(1L,"Enzo", LocalDate.now(), "Enzoloko8@gmail" ));

        return studentsList;
    }


}
