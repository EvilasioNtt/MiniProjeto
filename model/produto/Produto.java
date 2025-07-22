package loja.model.produto;
import java.math.BigDecimal;

public class Produto {
    private String codigo; 
    private String nome;
    private double precoBase; 
    public Produto(String codigo, String nome, BigDecimal precoBase) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoBase = precoBase != null ? precoBase : BigDecimal.ZERO;
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

    public BigDecimal getPrecoBase() {
        return precoBase;
    }
   public void setPrecoBase(BigDecimal precoBase) {
        if (precoBase == null || precoBase.compareTo(BigDecimal.ZERO) < 0) {
            this.precoBase = BigDecimal.ZERO;
        } else {
            this.precoBase = precoBase;
        }
    }

    public BigDecimal getPrecoVenda() {
        return precoBase;
    }
  public String getTipo() {
        return "GENÉRICO";
    }

    @Override
    public String toString() {
        return getTipo() + "[" + codigo + "] " + nome + " R$" + precoBase.toString();
    }
}
