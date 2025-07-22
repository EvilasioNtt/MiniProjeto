package loja.model.produto;

import java.math.BigDecimal;

public abstract class Produto {
    private String codigo;
    private String nome;
    private BigDecimal preco;
    private int estoque;

    public Produto(String codigo, String nome, BigDecimal preco, int estoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public abstract String getTipo();
}
