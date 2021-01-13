package com.ga.john.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository
    //The table gets created by Student class
    //Interface is to access database
        extends JpaRepository<Student,Long> { //fetch Student from database

    //SELECT * FROM student WHERE email = ?
    Optional<Student> findStudentByEmail(String email);

    //Or
    //@Query("SELECT s FROM Student s WHERE s.email =?1")
}
