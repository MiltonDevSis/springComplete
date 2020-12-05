package com.filho.milton.springcomplete.repositories;

import com.filho.milton.springcomplete.domain.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
