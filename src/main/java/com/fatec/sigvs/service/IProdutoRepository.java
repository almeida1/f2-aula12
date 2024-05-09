package com.fatec.sigvs.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.sigvs.model.Produto;

@Repository
public interface IProdutoRepository extends JpaRepository<Produto, Long> {
}