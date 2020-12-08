package com.filho.milton.springcomplete.services;

import java.util.Optional;

import com.filho.milton.springcomplete.domain.Cliente;
import com.filho.milton.springcomplete.repositories.ClienteRepository;
import com.filho.milton.springcomplete.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente buscar(Integer id) {

        Optional<Cliente> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
        "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
        
    } 
}
