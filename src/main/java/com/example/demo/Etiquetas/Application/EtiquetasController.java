package com.example.demo.Etiquetas.Application;

import com.example.demo.Etiquetas.Domain.EtiquetasService;
import com.example.demo.Etiquetas.dto.NewEtiquetasDto;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import com.example.demo.Etiquetas.Domain.EtiquetasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/Etiqueta")
public class EtiquetasController {
    @Autowired
    private EtiquetasService etiquetasService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody NewEtiquetasDto newEtiquetasDto) {
        String newItemLocation = etiquetasService.create(newEtiquetasDto);
        return ResponseEntity.created(URI.create(newItemLocation)).build();
    }
}
