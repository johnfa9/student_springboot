package com.ga.amigo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean //bean annotation runs the function, otherwise need to invoke function
    CommandLineRunner commandLineRunner(StudentRepository repository) {  //inject studentRepository
        return args -> {  //add record to database
            Student mariam =new Student(
                        "Mariam",
                        "Mariam@gmail.com",
                        LocalDate.of(2000, 4,15)
                        //age will also be retried from @Transient calculated field

            );

            Student alex =new Student(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2000, 1,15)


            );
            repository.saveAll(
                    List.of(mariam, alex)
            );
        };
    }
}
