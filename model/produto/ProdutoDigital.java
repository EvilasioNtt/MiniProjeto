package loja.model.produto;

import java.math.BigDecimal;

public class ProdutoFisico extends Produto {
    public ProdutoFisico(String codigo, String nome, BigDecimal preco, int estoque) {
        super(codigo, nome, preco, estoque);
    }

    public String getTipo() {
        return "Físico";
    }
}
