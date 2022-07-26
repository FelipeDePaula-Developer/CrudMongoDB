package com.comercio.loja.services;

import com.comercio.loja.entity.Produto;
import com.comercio.loja.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@Component
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public String cadastrarProduto(Integer valor, String descricao, String categoria, Integer estoque){
        Produto produto = produtoRepository.save(new Produto(valor, descricao, categoria, estoque));
        return produto.getId();
    }

    public String editarProduto(Map<String, Object> mapProduto){
        Produto produto = produtoRepository.findProdutoById(String.valueOf(mapProduto.get("Id")));
        if(produto != null){


            produto.setCategoria();

            Produto produto = produtoRepository.save(new Produto(id, valor, descricao, categoria, estoque))
        }
    }



}
