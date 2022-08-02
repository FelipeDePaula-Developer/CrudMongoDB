package com.comercio.loja.services;

import com.comercio.loja.config.SimpleMongoConfig;
import com.comercio.loja.entity.Produto;
import com.comercio.loja.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.commons.beanutils.*;

import static java.lang.Double.parseDouble;

@Component
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    private MongoTemplate mt = SimpleMongoConfig.mongoTemplate();

    public ProdutoService() throws Exception {

    }

    public String cadastrarProduto(Produto produto){
        produtoRepository.save(produto);
        return produto.getId();
    }

    public String editarProduto(Produto produto){
        if(produtoRepository.findProdutoById(produto.getId()) != null){
            produtoRepository.save(produto);
            return produto.getId();
        }
        return "Não foi possível editar";
    }

    public long countProduto(){
        return produtoRepository.count();
    }

    public List<Produto> consultarProduto(Produto produto) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is("62de11e43def1e078f07894e"));
        List<? extends Produto> produtos = mt.find(query, produto.getClass());
        return (List<Produto>) produtos;
    }
}
