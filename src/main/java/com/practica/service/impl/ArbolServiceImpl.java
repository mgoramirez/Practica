
package com.practica.service.impl;

import com.practica.dao.ArbolDao;
import com.practica.domain.Arbol;
import com.practica.service.ArbolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArbolServiceImpl implements ArbolService{
    
    @Autowired
    private ArbolDao arbolDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Arbol> getArboles() {
       List<Arbol> lista = arbolDao.findAll();
       return lista;
    }
    
}
