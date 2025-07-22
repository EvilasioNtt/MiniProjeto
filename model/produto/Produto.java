package loja.model.produto;

public abstract class Produto {
    private String codigo; 
    private String nome;
    private double precoBase; 
    public Produto(String codigo, String nome, BigDecimal precoBase) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoBase = precoBase;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        if (precoBase < 0) {
            precoBase = 0.0;
        }
        this.precoBase = precoBase;
    }

    public double getPrecoVenda() {
        return precoBase;
    }
