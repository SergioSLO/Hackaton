package com.example.demo.Salon.Domain;

import com.example.demo.Salon.Infraestructure.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalonService {
    @Autowired
    private SalonRepository salonRepository;


}
