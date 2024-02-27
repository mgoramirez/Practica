package com.practica.controller;

import com.practica.domain.Arbol;
import com.practica.service.ArbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.practica.service.FirebaseStorageServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/arbol")
public class ArbolController {

    @Autowired
    private ArbolService arbolService;

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @GetMapping("/listado")
    public String listado(Model model) {
        List<Arbol> lista = arbolService.getArboles();
        model.addAttribute("arboles", lista);
        return "arbol/listado";
    }

    @GetMapping("/nuevo")
    public String arbolNuevo(Model model) {
        model.addAttribute("arbol", new Arbol());
        return "arbol/modifica";
    }

    @PostMapping("/guardar")
    public String arbolGuardar(@ModelAttribute("arbol") Arbol arbol, @RequestParam("imagenFile") MultipartFile imagenFile, Model model) {
        try {
            if (!imagenFile.isEmpty()) {
                String nombreArchivo = imagenFile.getOriginalFilename();
                String carpeta = "imagenes_arboles";
                String urlImagen = firebaseStorageService.cargaImagen(imagenFile, carpeta, nombreArchivo);
                if (urlImagen != null) {
                    arbol.setRutaImagen(urlImagen);
                } else {
                    model.addAttribute("error", "Error al cargar la imagen.");
                    return "arbol/modifica";
                }
            }
            arbolService.save(arbol);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Error al guardar el árbol.");
            return "arbol/modifica";
        }
        return "redirect:/arbol/listado";
    }

    @GetMapping("/eliminar/{idArbol}")
    public String arbolEliminar(@PathVariable("idArbol") Long idArbol) {
        arbolService.delete(idArbol);
        return "redirect:/arbol/listado";
    }

    @GetMapping("/modificar/{idArbol}")
    public String arbolModificar(@PathVariable("idArbol") Long idArbol, Model model) {
        Arbol arbol = arbolService.getArbol(idArbol);
        model.addAttribute("arbol", arbol);
        return "arbol/modifica";
    
}
    
}
