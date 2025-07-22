package loja.model.cliente;

public class PessoaFisica extends Cliente {
    public PessoaFisica(String id, String nome, String endereco, String telefone) {
        super(id, nome, endereco, telefone);
    }

    public String getTipo() {
        return "Pessoa Física";
    }
}
