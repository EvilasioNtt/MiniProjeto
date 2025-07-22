package loja.model.cliente;

public class PessoaJuridica extends Cliente {
    public PessoaJuridica(String id, String nome, String endereco, String telefone) {
        super(id, nome, endereco, telefone);
    }

    public String getTipo() {
        return "Pessoa Jurídica";
    }
}
