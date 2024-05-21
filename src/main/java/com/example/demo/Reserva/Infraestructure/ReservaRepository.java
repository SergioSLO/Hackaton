package com.example.demo.Reserva.Infraestructure;

import com.example.demo.Reserva.Domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}
