package br.com.domains.Cartao;

import br.com.domains.Compras.Compra;

import java.time.LocalDate;

public class CartaoCredito {
    private Double credito; // Limite do cartão
    private Double saldo;
    private String nomeDoTitular;
    private Double fatura;
    private LocalDate dataDeVencimento;
    private Double sumCreditoSaldo;

    public CartaoCredito(Double saldo, String nomeDoTitular) {
        this.credito = 1000.0;
        this.saldo = saldo;
        this.nomeDoTitular = nomeDoTitular;
        this.fatura = 0.0;
        // Se o cliente gastou 1500 reais e ele tinha de saldo 500 fatura vem 1000
        // , mas caso ele não tenha limite suficiente ele não poderá fazer a compra
        this.dataDeVencimento = LocalDate.now().plusDays(30);
        this.sumCreditoSaldo = this.credito + this.saldo;
    }

    public Double getCredito() {
        return credito;
    }

    public Double getSaldo() {
        return saldo;
    }

    public String getNomeDoTitular() {
        return nomeDoTitular;
    }

    public Double getFatura() {
        return fatura;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public Boolean efetuarCompra(Compra compra, String Credito, String Saldo) {
        if (Credito.equals("credito") && Saldo.equals("saldo")) {
            if(sumCreditoSaldo >= compra.getTotalPrice()){
                if (this.saldo < compra.getTotalPrice()) {
                    this.fatura += compra.getTotalPrice() - this.saldo; // (1100 - 1000) = 100
                    this.credito -= compra.getTotalPrice() - this.saldo; // 1100 - 1000 = 100 - 100 = 900
                    this.saldo = 0.0;
                    return true;
                } else {
                    this.saldo -= compra.getTotalPrice();
                    return true;
                }
            }else {
                System.out.println("Crédito e saldo insuficiente");
                return false;
            }
        }else {
            System.out.println("Forma de pagamento inválida");
            return false;
        }
    }

    public Boolean efetuarCompra(Compra compra, String pagamento) {
        if(pagamento.toLowerCase().strip().equals("credito")){
            if(this.credito >= compra.getTotalPrice()){
                this.credito -= compra.getTotalPrice();
                this.fatura += compra.getTotalPrice();
                return true;
            }else {
                System.out.println("Crédito insuficiente");
                return false;
            }
        }else if (pagamento.toLowerCase().strip().equals("saldo")){
            System.out.println("Saldo: "+this.saldo);
            System.out.println("Compra: "+ compra.getTotalPrice());
            if(this.saldo >= compra.getTotalPrice()){
                this.saldo -= compra.getTotalPrice();
                return true;
            }else{
                System.out.println("Saldo insuficiente DEU AQUI A BOMBA");
                return false;
            }
        }else{
            System.out.println("Forma de pagamento inválida");
            return false;
        }
    }



    @Override
    public String toString() {
        return "Nome do titular: " + this.nomeDoTitular
                + "\n Saldo: " + this.saldo
                + "\n Crédito disponível: " + this.credito;
    }
}
