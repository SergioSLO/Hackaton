package com.example.demo.Etiquetas.Application;

import com.example.demo.Etiquetas.Domain.EtiquetasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class EtiquetasController {

    @Autowired
    private EtiquetasService etiquetasService;

}
