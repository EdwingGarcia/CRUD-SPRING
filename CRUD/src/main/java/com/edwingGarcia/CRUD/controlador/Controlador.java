package com.edwingGarcia.CRUD.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edwingGarcia.CRUD.model.Inversion;
import com.edwingGarcia.CRUD.service.InversionService;

@Controller
@RequestMapping("/inversiones")
public class Controlador {

    private final InversionService inversionService;

    @Autowired
    public Controlador(InversionService inversionService) {
        this.inversionService = inversionService;
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Inversion> inversiones = inversionService.listar();
        model.addAttribute("inversiones", inversiones);
        return "index"; 
    }

    @PostMapping("/guardar")
    public String guardar(Inversion inversion) {
        inversionService.guardar(inversion); 
        return "redirect:/inversiones/listar"; 
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Inversion inversion = inversionService.obtenerPorId(id);
        model.addAttribute("inversion", inversion);
        return "formulario-editar"; 
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        inversionService.eliminar(id);
        return "redirect:/inversiones/listar";
    }

}
