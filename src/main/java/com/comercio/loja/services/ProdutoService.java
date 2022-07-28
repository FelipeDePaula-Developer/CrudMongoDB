package com.comercio.loja.services;

import com.comercio.loja.entity.Produto;
import com.comercio.loja.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import org.apache.commons.beanutils.*;

import static java.lang.Double.parseDouble;

@Component
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public String cadastrarProduto(Double valor, String descricao, String categoria, Integer estoque){
        Produto produto = produtoRepository.save(new Produto(valor, descricao, categoria, estoque));
        return produto.getId();
    }

    public String editarProduto(Map<String, Object> mapProduto){
        Produto produto = produtoRepository.findProdutoById(String.valueOf(mapProduto.get("id")));
        if(produto != null){
            mapProduto.remove("id");
            mapProduto.forEach((k, v) -> {
                if (v !=null) {
                    try {
                        BeanUtils.setProperty(produto, k, v);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            });
            produtoRepository.save(produto);
            return produto.getId();
        }
        return "Não foi possível editar";
    }
}
