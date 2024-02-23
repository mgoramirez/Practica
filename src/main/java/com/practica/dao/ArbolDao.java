
package com.practica.dao;

import com.practica.domain.Arbol;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArbolDao extends JpaRepository<Arbol, Long>{

    public Object findIdBy(Long idArbol);
    
}
