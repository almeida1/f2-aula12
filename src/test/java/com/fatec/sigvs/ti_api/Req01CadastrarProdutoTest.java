package com.fatec.sigvs.ti_api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.fatec.sigvs.model.Produto;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class Req01CadastrarProdutoTest {
    String urlBase = "/api/v1/produtos";
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void ct01_quando_dados_validos_cadatra_produto_com_sucesso() {
        Produto produto = new Produto("Eletrobomba 110V para Maquina de Lavar e Lava Louças", "maquina de lavar",
                "51.66",
                "12");

        ResponseEntity<Produto> result = testRestTemplate.postForEntity(urlBase, produto, Produto.class);
        assertEquals("201 CREATED", result.getStatusCode().toString());
    }
}