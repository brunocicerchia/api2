package com.aude.api2.service;

import com.aude.api2.entity.EstadoReclamo;
import com.aude.api2.entity.Reclamo;
import com.aude.api2.repository.ReclamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aude.api2.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ReclamoService {

    @Autowired
    private ReclamoRepository reclamoRepository;

    public Reclamo crearReclamo(Reclamo reclamo) {
        reclamo.setEstado(EstadoReclamo.NUEVO); // O establecer un estado predeterminado
        return reclamoRepository.save(reclamo);
    }

    public List<Reclamo> obtenerTodosLosReclamos() {
        return reclamoRepository.findAll();
    }

    public Optional<Reclamo> obtenerReclamoPorId(Long id) {
        return reclamoRepository.findById(id);
    }

    public Reclamo actualizarReclamo(Long id, Reclamo reclamoActualizado) {
        Reclamo reclamoExistente = reclamoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reclamo no encontrado con id " + id));
        // Actualiza las propiedades necesarias
        reclamoExistente.setDescripcion(reclamoActualizado.getDescripcion());
        // Actualiza otros campos según sea necesario
        return reclamoRepository.save(reclamoExistente);
    }

    public void eliminarReclamo(Long id) {
        Reclamo reclamoExistente = reclamoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reclamo no encontrado con id " + id));
        reclamoRepository.delete(reclamoExistente);
    }

    // Otros métodos según sea necesario
}