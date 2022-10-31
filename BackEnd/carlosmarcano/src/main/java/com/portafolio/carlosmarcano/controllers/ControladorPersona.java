package com.portafolio.carlosmarcano.controllers;

import com.portafolio.carlosmarcano.models.Persona;
import com.portafolio.carlosmarcano.services.ServicioPersona;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:4200")

public class ControladorPersona {

    private final ServicioPersona servicioPersona;

    @GetMapping("/listar")
    public ResponseEntity listarPersonas() {
        return new ResponseEntity(servicioPersona.listarPersonas(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/guardar")
    public ResponseEntity guardarPersona(@RequestBody Persona persona){
        return new ResponseEntity(servicioPersona.guardarPersona(persona), HttpStatus.CREATED);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity obtenerPersona(@PathVariable("id") Long idPersona) {
        return new ResponseEntity(servicioPersona.obtenerPersona(idPersona), HttpStatus.OK);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/modificar/{id}")
    public ResponseEntity modificarPersona(@PathVariable("id") Long idPersona, @RequestBody Persona persona) {
        return new ResponseEntity(servicioPersona.modificarPersona(idPersona,persona), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity eliminarPersona(@PathVariable("id") Long idPersona) {
        boolean respuesta = servicioPersona.eliminarPersona(idPersona);
        if (respuesta == true){
            return new ResponseEntity("Persona Eliminada", HttpStatus.OK);
        }
        else{
            return new ResponseEntity("Persona No Existe",HttpStatus.NOT_FOUND);
        }
    }
}