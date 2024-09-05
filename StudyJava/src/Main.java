import br.com.domains.Cartao.CartaoCredito;
import br.com.domains.Compras.Compra;
import br.com.domains.Produtos.Produto;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Produto produto1 = new Produto("Arroz", 100.0);
        Produto produto2 = new Produto("Feijão", 100.0);
        Produto produto3 = new Produto("Macarrão", 100.0);
        Produto produto4 = new Produto("Carne", 100.0);
        Produto produto5 = new Produto("Frango", 10600.0); // 11000
        Compra compra = new Compra(List.of(produto1, produto2, produto3, produto4, produto5));
        System.out.println("Total Price: "+compra.getTotalPrice());
        CartaoCredito cartao = new CartaoCredito(10000.0, "João");
        System.out.println(cartao.efetuarCompra(compra, "credito", "saldo"));
        System.out.println("Fatura:");
        System.out.println(cartao.getFatura());
        System.out.println("Credito:");
        System.out.println(cartao.getCredito());
        System.out.println("Saldo:");
        System.out.println(cartao.getSaldo());

    }
}