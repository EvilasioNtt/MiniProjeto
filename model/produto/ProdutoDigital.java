package loja.model.produto;

import java.math.BigDecimal;

public class ProdutoDigital extends Produto {
    public ProdutoDigital(String codigo, String nome, BigDecimal preco, int estoque) {
        super(codigo, nome, preco, estoque);
    }

    public String getTipo() {
        return "Digital";
    }
}

