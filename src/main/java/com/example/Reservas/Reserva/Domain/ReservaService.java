package com.example.Reservas.Reserva.Domain;

import com.example.Reservas.Reserva.Infraestructure.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;
}