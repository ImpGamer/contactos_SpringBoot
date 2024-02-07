package com.imp.contactos.repository;

import com.imp.contactos.entity.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface contactoRepository extends JpaRepository<Contacto,Long> {
}