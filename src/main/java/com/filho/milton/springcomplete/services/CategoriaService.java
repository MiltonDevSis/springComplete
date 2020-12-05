package com.filho.milton.springcomplete.services;

import java.util.Optional;

import com.filho.milton.springcomplete.domain.Categoria;
import com.filho.milton.springcomplete.repositories.CategoriaRepositoty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepositoty repo;

    public Optional<Categoria> buscar(Integer id) {

        Optional<Categoria> obj = repo.findById(id);
        return obj;

    }
}
