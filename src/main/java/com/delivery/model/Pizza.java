package com.delivery.model;

public class Pizza extends Produto {
    private String sabor;

    public Pizza(String nome, double preco, String sabor) {
        super(nome, preco);
        this.sabor = sabor;
    }

    public String getSabor() { return sabor; }
}
