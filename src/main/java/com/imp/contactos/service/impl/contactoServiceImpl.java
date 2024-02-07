package com.imp.contactos.service.impl;

import com.imp.contactos.entity.Contacto;
import com.imp.contactos.repository.contactoRepository;
import com.imp.contactos.service.contactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class contactoServiceImpl implements contactoService {
    @Autowired
    private contactoRepository contactoRepository;

    @Override
    public void agregarContacto(Contacto contacto) {
        contactoRepository.save(contacto);
    }

    @Override
    public void eliminarContacto(Long id) {
        contactoRepository.deleteById(id);
    }

    @Override
    public Contacto buscarContacto_ID(Long id) {
        return contactoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Contacto> mostrarContactos() {
        return contactoRepository.findAll();
    }

    @Override
    public void editarContacto(Long id, Contacto contacto) {
        Contacto contactoBBDD = contactoRepository.findById(id).orElse(null);
        if(contactoBBDD != null) {
            contactoBBDD.setNombre(contacto.getNombre());
            contactoBBDD.setTelefono(contacto.getTelefono());
            contactoBBDD.setEmail(contacto.getEmail());
            contactoBBDD.setFechaNacimiento(contacto.getFechaNacimiento());
            contactoRepository.save(contactoBBDD);
        }
    }
    @Override
    public Long cantidadContactosReg() {
        return contactoRepository.count();
    }
}
