package com.comercio.loja.controller;

import com.comercio.loja.entity.Produto;
import com.comercio.loja.repository.ProdutoRepository;
import com.comercio.loja.services.ProdutoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping("cad/produto")
    public String cadProduto(@RequestParam Double valor, @RequestParam String descricao, @RequestParam String categoria, @RequestParam Integer estoque) {
        return produtoService.cadastrarProduto(valor, descricao, categoria, estoque);
    }

    @PostMapping("edit/produto")
    public String editProduto(@RequestParam String id, @RequestBody String camposJson) throws JsonProcessingException {
        Map<String, Object> mapProduto = new ObjectMapper().readValue(camposJson, Map.class);
        mapProduto.put("id", id);
        return produtoService.editarProduto(mapProduto);
    }
}
