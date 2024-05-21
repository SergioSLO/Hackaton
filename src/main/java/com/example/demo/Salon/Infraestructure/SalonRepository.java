package com.example.demo.Salon.Infraestructure;

import com.example.demo.Salon.Domain.Salon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalonRepository extends JpaRepository<Salon, Integer> {

}
