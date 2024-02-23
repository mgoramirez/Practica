
package com.practica.service;

import com.practica.domain.Arbol;
import java.util.List;


public interface ArbolService {
    
    public List<Arbol> getArboles();
    
    public Arbol getArbol(Arbol arbol );
    
    public void save(Arbol arbol);
    
    public void delete(Arbol arbol);
}
