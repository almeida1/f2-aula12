package com.fatec.sigvs.ti_servico;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fatec.sigvs.service.IProdutoRepository;
import com.fatec.sigvs.model.Produto;
import com.fatec.sigvs.service.IProdutoServico;

@SpringBootTest
class Req01CadastrarProdutoTests {
    @Autowired
    IProdutoServico servico;
    @Autowired
    IProdutoRepository repository;

    @Test
    void ct01CadastrarProdutoComSucesso() {
        // dado que nao existem produtos cadastrados
        repository.deleteAll();
        Produto produto1 = new Produto("eletrobomba 110v", "maquina de lavar", "22.30", "10");
        // quando cadastro um produto
        servico.cadastrar(produto1);
        // entao retorna 1
        assertEquals(1, repository.count());
    }
}
