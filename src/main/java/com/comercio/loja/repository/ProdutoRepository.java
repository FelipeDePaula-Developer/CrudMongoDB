package com.comercio.loja.repository;

import com.comercio.loja.entity.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> {
    Produto findProdutoById (String id);
}
