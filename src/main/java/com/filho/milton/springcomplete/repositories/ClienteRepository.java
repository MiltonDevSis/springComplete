package com.filho.milton.springcomplete.repositories;

import com.filho.milton.springcomplete.domain.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}
