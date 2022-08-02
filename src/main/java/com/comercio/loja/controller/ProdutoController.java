package com.comercio.loja.controller;

import com.comercio.loja.entity.Produto;
import com.comercio.loja.repository.ProdutoRepository;
import com.comercio.loja.services.ProdutoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping("cad/produto")
    public String cadProduto(@RequestBody Produto produto) {
        return produtoService.cadastrarProduto(produto);
    }

    @PostMapping("edit/produto")
    public String editProduto(@RequestBody Produto produto) throws JsonProcessingException {
        return produtoService.editarProduto(produto);
    }

    @GetMapping("count/produto")
    public Long countProduto(){
        return produtoService.countProduto();
    }

    @GetMapping("consult/produto")
    public List<Produto> consultProduto(@RequestBody Produto produto){
        return produtoService.consultarProduto(produto);
    }
}
