package com.aude.api2.controller;

import com.aude.api2.entity.Reclamo;
import com.aude.api2.service.ReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reclamos")
public class ReclamoController {

    @Autowired
    private ReclamoService reclamoService;

    @GetMapping("/reclamos")
    public List<Reclamo> obtenerReclamos() {
        return reclamoService.obtenerTodosLosReclamos();
    }

    @GetMapping("/reclamos/{id}")
    public ResponseEntity<Reclamo> obtenerReclamoPorId(@PathVariable Long id) {
        Optional<Reclamo> reclamo = reclamoService.obtenerReclamoPorId(id);
        return reclamo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/reclamos/{id}")
    public ResponseEntity<Reclamo> actualizarReclamo(@PathVariable Long id, @RequestBody Reclamo reclamoActualizado) {
        Reclamo reclamo = reclamoService.actualizarReclamo(id, reclamoActualizado);
        return ResponseEntity.ok(reclamo);
    }

    @DeleteMapping("/reclamos/{id}")
    public ResponseEntity<Void> eliminarReclamo(@PathVariable Long id) {
        reclamoService.eliminarReclamo(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/reclamos")
    public ResponseEntity<Reclamo> crearReclamo(@RequestBody Reclamo reclamo) {
        Reclamo nuevoReclamo = reclamoService.crearReclamo(reclamo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoReclamo);
    }


    // Otros métodos para actualizar, eliminar, etc.
}

