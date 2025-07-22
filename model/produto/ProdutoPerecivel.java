package loja.model.produto;

import java.math.BigDecimal;

public class ProdutoPerecivel extends Produto {
    public ProdutoPerecivel(String codigo, String nome, BigDecimal preco, int estoque) {
        super(codigo, nome, preco, estoque);
    }

    public String getTipo() {
        return "Perecível";
    }
}
