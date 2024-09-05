package br.com.domains.Compras;

import br.com.domains.Produtos.Produto;

import java.util.List;

public class Compra {
    private List<Produto> produtos;
    private Double totalPrice = 0.0;

    public Compra(List<Produto> produtos) {
        this.produtos = produtos;
        this.totalPrice = calcularTotal();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    private Double calcularTotal() {
        Double sum = 0.0;
        for(Produto produto: produtos){
            sum += produto.getPreco();
        }
        return sum;
    }

    public void setTotalPrice() {
        this.totalPrice = calcularTotal();
    }


    public Double getTotalPrice() {
        return this.totalPrice;
    }

}
