package com.aude.api2.repository;

import com.aude.api2.entity.Edificio;
import com.aude.api2.entity.EstadoReclamo;
import com.aude.api2.entity.Reclamo;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;


public interface ReclamoRepository extends JpaRepository<Reclamo, Long> {


    @Entity
    @Table(name = "reclamos")
    public class Reclamo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String descripcion;

        @ManyToOne // Suponiendo que cada reclamo pertenece a un edificio
        @JoinColumn(name = "edificio_id", nullable = false)
        private Edificio edificio;

        @Enumerated(EnumType.STRING)
        private EstadoReclamo estado;

        private LocalDateTime fechaCreacion;

        // Constructor, Getters y Setters

        public Reclamo() {
            this.fechaCreacion = LocalDateTime.now(); // Establece la fecha de creación automáticamente
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public Edificio getEdificio() {
            return edificio;
        }

        public void setEdificio(Edificio edificio) {
            this.edificio = edificio;
        }

        public EstadoReclamo getEstado() {
            return estado;
        }

        public void setEstado(EstadoReclamo estado) {
            this.estado = estado;
        }

        public LocalDateTime getFechaCreacion() {
            return fechaCreacion;
        }

        public void setFechaCreacion(LocalDateTime fechaCreacion) {
            this.fechaCreacion = fechaCreacion;
        }
    }

}

