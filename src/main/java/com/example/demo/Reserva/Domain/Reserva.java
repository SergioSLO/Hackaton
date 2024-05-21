package com.example.demo.Reserva.Domain;

import com.example.demo.Salon.Domain.Salon;
import com.example.demo.Usuario.Domain.Usuario;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Data
@Entity
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idReserva;

    private Date fecha;

    private Time horaInicio;

    private Time horaFin;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Salon salon;
}
