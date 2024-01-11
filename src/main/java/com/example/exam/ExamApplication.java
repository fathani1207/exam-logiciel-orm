package com.example.exam;

import com.example.exam.dao.ApplicationDao;
import com.example.exam.entities.Version;
import com.example.exam.entities.logiciel.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExamApplication {


    public static void main(String[] args) {
        SpringApplication.run(ExamApplication.class, args);
    }


}
