package loja.model.cliente;

public class PessoaFisica extends Cliente implements ICliente {
    public PessoaFisica(String id, String nome, String endereco, String telefone) {
        super(id, nome, endereco, telefone);
    }

    @Override
    public String getTipo() {
        return "Pessoa Física";
    }
}
