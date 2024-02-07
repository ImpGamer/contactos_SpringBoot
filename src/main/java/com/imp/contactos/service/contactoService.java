package com.imp.contactos.service;

import com.imp.contactos.entity.Contacto;

import java.util.List;

public interface contactoService {
    void agregarContacto(Contacto contacto);
    void eliminarContacto(Long id);
    Contacto buscarContacto_ID(Long id);
    List<Contacto> mostrarContactos();
    void editarContacto(Long id,Contacto contacto);
    Long cantidadContactosReg();
}