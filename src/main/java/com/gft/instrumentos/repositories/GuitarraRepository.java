package com.gft.instrumentos.repositories;

import com.gft.instrumentos.entities.Guitarra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuitarraRepository extends JpaRepository<Guitarra, Long> {
}
