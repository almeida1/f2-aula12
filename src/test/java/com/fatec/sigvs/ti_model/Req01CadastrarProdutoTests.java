package com.fatec.sigvs.ti_model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.sigvs.service.IProdutoRepository;
import com.fatec.sigvs.model.Produto;

@SpringBootTest
class Req01CadastrarProdutoTests {
    @Autowired
    IProdutoRepository repository;

    @Test
    void ct01_cadastrar_produto_com_sucesso() {
        // dado um produto
        Produto produto1 = new Produto("eletrobomba 110v", "maquina de lavar", "22.30", "10");
        // quando salvo o produto
        Produto p = repository.save(produto1);
        // entao o repositorio eh incrementado de 1
        assertTrue(repository.count() >= 1);

    }

    @Test
    void ct02_cadastrar_produto_descricao_invalida_em_branco() {
        Produto produto = null;
        try {
            produto = new Produto("", "maquina de lavar", "22.30", "10");
            fail("deveria falhar para descrição invalida");
        } catch (Exception e) {
            assertEquals("A descrição não deve estar em branco", e.getMessage());
            assertNull(produto);
        }
    }

    @Test
    void ct03_cadastrar_produto_com_categoria_invalida_em_branco() {
        Produto produto = null;
        try {
            produto = new Produto("eletrobomba 110v", "", "22.30", "10");
            fail("deveria falhar para categoria invalida");
        } catch (Exception e) {
            assertEquals("A categoria não deve estar em branco", e.getMessage());
            assertNull(produto);
        }
    }

    @Test
    void ct04_cadastrar_produto_com_quantidade_invalida_menor_zero() {
        Produto produto = null;
        try {
            produto = new Produto("eletrobomba 110v", "maquina de lavar", "22.30", "-20");
            fail("deveria falhar para quantidade invalida");
        } catch (Exception e) {
            assertEquals("A quantidade no estoque deve ser maior que zero", e.getMessage());
            assertNull(produto);
        }
    }

    @Test
    void ct05_cadastrar_produto_com_custo_invalido_menor_zero() {
        Produto produto = null;
        try {
            produto = new Produto("eletrobomba 110v", "maquina de lavar", "-22.30", "20");
            fail("deveria falhar para custo invalido");
        } catch (Exception e) {
            assertEquals("O custo deve ser maior que zero", e.getMessage());
            assertNull(produto);
        }
    }

    @Test
    void ct06_quando_produto_cadastrado_obtem_id() {
        // dado um produto
        Produto produto1 = new Produto("eletrobomba 110v", "maquina de lavar", "22.30", "10");
        // quando salvo o produto
        Produto p = repository.save(produto1);
        // entao o repositorio eh incrementado de 1
        Long id = p.getId();
        assertTrue(id >= 1);
    }
}
