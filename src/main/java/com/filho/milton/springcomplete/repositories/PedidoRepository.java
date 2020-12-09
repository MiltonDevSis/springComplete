package com.filho.milton.springcomplete.repositories;

import com.filho.milton.springcomplete.domain.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
    
}
