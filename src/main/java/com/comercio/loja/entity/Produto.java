package com.comercio.loja.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document("produto")
@Component
public class Produto {

    @Id
    private String id;
    private Integer valor;
    private String descricao;
    private String categoria;
    private Integer estoque;

    public Produto() {

    }

    public Produto(Integer valor, String descricao, String categoria, Integer estoque) {
        this.valor = valor;
        this.descricao = descricao;
        this.categoria = categoria;
        this.estoque = estoque;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
}
