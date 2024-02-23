
package com.practica.controller;

import com.practica.domain.Arbol;
import com.practica.service.ArbolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/arbol")
public class ArbolController {
    
    @Autowired
    ArbolService arbolService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
        List<Arbol> lista = arbolService.getArboles();
        model.addAttribute("Arbol", lista);
        return "/arbol/listado";
    }
    
}
