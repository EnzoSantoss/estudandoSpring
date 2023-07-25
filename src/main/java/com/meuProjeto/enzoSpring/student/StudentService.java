package com.meuProjeto.enzoSpring.student;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }



    public List<Student> getStudentList(){

        return studentRepository.findAll();

//        List<Student> studentsList = List.of(new Student(1L,"Enzo", LocalDate.now(), "Enzoloko8@gmail" ));
//
//        return studentsList;
    }

    public void createStudent(Student student){

        Optional<Student> studentByEmail = studentRepository.findStudenteByEmail(student.getEmail());

        if(studentByEmail.isPresent()){
            throw new IllegalStateException("Email já cadastrado");
        }
        studentRepository.save(student);
        //studentRepository.save(student);
    }


}
