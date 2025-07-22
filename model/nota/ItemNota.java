package loja.model.nota;

import loja.model.produto.Produto;
import java.math.BigDecimal;

public class ItemNota {
    private Produto produto;
    private int quantidade;

    public ItemNota(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getSubtotal() {
        return produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
    }
}
