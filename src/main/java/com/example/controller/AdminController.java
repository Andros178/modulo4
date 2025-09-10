package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/m4/admin")
public class AdminController {

    @GetMapping("/Gestion")
    public String holaMundo() {
        return "¡Lista de recursos";
    }
    @GetMapping("/public")
    public String holaMundo2() {
        return "Listado publico de fechas de admisiones";
    }
}
