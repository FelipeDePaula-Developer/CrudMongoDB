package com.comercio.loja.config;


import com.comercio.loja.entity.Produto;
import com.comercio.loja.repository.ProdutoRepository;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
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

@Configuration
public class SimpleMongoConfig {
    public static MongoClient mongo(){
        ConnectionString connectionString = new ConnectionString("mongodb+srv://root:987654321@produto.fttmpbz.mongodb.net/myFirstDatabase");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).build();

        return MongoClients.create(mongoClientSettings);
    }

    public static MongoTemplate mongoTemplate() throws Exception{
        return new MongoTemplate(mongo(), "produtos");
    }
}
