package com.filho.milton.springcomplete.repositories;

import com.filho.milton.springcomplete.domain.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositoty extends JpaRepository<Categoria, Integer>{
    
}
