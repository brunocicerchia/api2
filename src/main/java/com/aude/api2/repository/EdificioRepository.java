package com.aude.api2.repository;

import com.aude.api2.entity.Edificio;
import com.aude.api2.entity.Reclamo;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;

import java.util.List;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {

    @Entity
    @Table(name = "edificios")
    public class Edificio {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nombre;

        @OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL)
        private List<Reclamo> reclamos;

        // Constructor, Getters y Setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public List<Reclamo> getReclamos() {
            return reclamos;
        }

        public void setReclamos(List<Reclamo> reclamos) {
            this.reclamos = reclamos;
        }
    }

}
