package com.example.demo.Salon.Domain;

import com.example.demo.Salon.Infraestructure.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalonService {
    @Autowired
    private SalonRepository salonRepository;


    public List<Salon> getSalones(){
        return salonRepository.findAll();
    }

    public Salon createSalon(Salon salon){
        if (salonRepository.findById(salon.getId()).isPresent()){

        }

        salonRepository.save(salon);
        return null;
    }


    public Salon putSalon(Integer id){
        return null;}

    public Salon delete(Integer id){
        return null;

    }
}
