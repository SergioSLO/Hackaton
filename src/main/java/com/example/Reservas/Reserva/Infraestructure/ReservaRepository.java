package com.example.Reservas.Reserva.Infraestructure;

import com.example.Reservas.Reserva.Domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}
