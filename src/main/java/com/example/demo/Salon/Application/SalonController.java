package com.example.demo.Salon.Application;

import com.example.demo.Salon.Domain.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservas")
public class SalonController {
    @Autowired
    private SalonService salonService;

}
