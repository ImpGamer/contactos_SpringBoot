package com.imp.contactos.entity.controller;

import com.imp.contactos.entity.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.imp.contactos.service.contactoService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contactos")
public class ContactoController {
    @Autowired
    private contactoService contactoService;
    @GetMapping
    public String misContactos(Model model) {
        model.addAttribute("contactos",contactoService.mostrarContactos());
        model.addAttribute("cantidadCont",contactoService.cantidadContactosReg());

        return "index";
    }
    //Formulario para agregar contacto
    @GetMapping("/nuevoContacto")
    public String mostrarFormContacto(Model model) {
        model.addAttribute("contacto",new Contacto());
        model.addAttribute("direccion","/contactos/nuevoContacto");

        return "formularioContacto";
    }
    @PostMapping("/nuevoContacto")
    public String recibirContacto(@Validated Contacto contacto, BindingResult bindingResult, RedirectAttributes redirect, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("contacto",contacto);
            return "formularioContacto";
        }

        contactoService.agregarContacto(contacto);
        redirect.addFlashAttribute("msgExito","El contacto fue guardado exitosamente");

        return "redirect:/contactos";
    }
    @GetMapping("/editar/{id}")
    public String editarContactoForm(@PathVariable Long id,Model model) {
        model.addAttribute("contacto",contactoService.buscarContacto_ID(id));
        model.addAttribute("direccion","/contactos/editar/"+id);

        return "formularioContacto";
    }
    @PostMapping("/editar/{id}")
    public String editarContactoExis(@PathVariable Long id,@Validated Contacto contacto,BindingResult bindingResult,RedirectAttributes redirect,Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("contacto",contacto);
            return "formularioContacto";
        }

        contactoService.editarContacto(id,contacto);
        redirect.addFlashAttribute("msgExito","La edicion del contacto fue exitosa!");
        return "redirect:/contactos";
    }
    @GetMapping("/{id}")
    public String eliminarContacto(@PathVariable Long id,RedirectAttributes redirect) {
        contactoService.eliminarContacto(id);
        redirect.addFlashAttribute("msgExito","El contacto fue eliminado con exito");

        return "redirect:/contactos";
    }

}