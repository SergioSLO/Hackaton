package com.example.demo.Salon.Application;

import com.example.demo.Salon.Domain.Salon;
import com.example.demo.Salon.Domain.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class SalonController {
    @Autowired
    private SalonService salonService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("")
    public ResponseEntity<List<Salon>> getSalon() {
        return ResponseEntity.ok(salonService.getSalones());
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("")
    public ResponseEntity<Salon> postSalon(@RequestBody Salon salon) {
        return ResponseEntity.ok(salonService.createSalon(salon));
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("/{id}")
    public ResponseEntity<Salon> putSalon(@PathVariable Integer id) {
        return ResponseEntity.ok(salonService.putSalon(id));
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Salon> deleteSalon(@PathVariable Integer id) {
        return ResponseEntity.ok(salonService.delete(id));
    }

//    GET /salones
//    POST /salones
//    PUT /salones/{id}
//    DELETE /salones/{id}


}
