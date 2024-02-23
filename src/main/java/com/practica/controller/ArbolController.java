
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
    @GetMapping("/nuevo")
    public String ArbolNuevo(Arbol arbol) {
        return "/arbol/modifica";
    }

   /* @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;*/
    /*
    @PostMapping("/guardar")
    public String arbolGuardar(Arbol categoria,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            arbolService.save(categoria);
            arbol.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "arbol", 
                            arbol.getIdCategoria()));
        }
        arbolService.save(categoria);
        return "redirect:/arbol/listado";
    }
*/
    @GetMapping("/eliminar/{idArbol}")
    public String arbolEliminar(Arbol categoria) {
        arbolService.delete(categoria);
        return "redirect:/arbol/listado";
    }

    @GetMapping("/modificar/{idArbol}")
    public String arbolModificar(Arbol arbol, Model model) {
        arbol = arbolService.getArbol(arbol);
        model.addAttribute("arbol", arbol);
        return "/arbol/modifica";
    }
}
