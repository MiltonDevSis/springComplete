package com.filho.milton.springcomplete.repositories;

import com.filho.milton.springcomplete.domain.ItemPedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>{
    
}
