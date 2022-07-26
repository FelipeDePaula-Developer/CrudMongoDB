package com.comercio.loja.controller;

import com.comercio.loja.entity.Produto;
import com.comercio.loja.repository.ProdutoRepository;
import com.comercio.loja.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String cadProduto(@RequestParam Integer valor, @RequestParam String descricao, @RequestParam String categoria, @RequestParam Integer estoque) {
        return produtoService.cadastrarProduto(valor, descricao, categoria, estoque);
    }

    @PostMapping("edit/produto")
    public String editProduto(@RequestParam String id, @RequestParam Integer valor, @RequestParam String descricao, @RequestParam String categoria, @RequestParam Integer estoque) {
        Map<String, Object> mapProduto = new HashMap<String, Object>();

        mapProduto.put("Id", id);
        mapProduto.put("Valor", valor);
        mapProduto.put("Descricao", descricao);
        mapProduto.put("Categoria", categoria);
        mapProduto.put("Estoque", estoque);

        return produtoService.editarProduto(mapProduto);
    }
}
