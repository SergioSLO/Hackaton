package com.example.demo.Salon.Infraestructure;

import com.example.demo.Student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalonRepository extends JpaRepository<Student, Integer> {

}
