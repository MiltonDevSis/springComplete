package com.filho.milton.springcomplete.repositories;

import com.filho.milton.springcomplete.domain.Pagamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{
    
}
