package com.practica.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    final String BucketName = "practica01-19815.appspot.com";

    final String rutaSuperiorStorage = "practica1";

    final String rutaJsonFile = "firebase";
    
    final String archivoJsonFile = "practica01-19815-firebase-adminsdk-7gg0x-531a4b80fe.json";
}