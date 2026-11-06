package com.delivery.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String id;
    private List<Produto> produtos = new ArrayList<>();
    private double valorTotal;

    public Pedido(String id) {
        this.id = id;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        valorTotal += produto.getPreco();
    }

    public String getId() { return id; }
    public List<Produto> getProdutos() { return produtos; }
    public double getValorTotal() { return valorTotal; }
}
