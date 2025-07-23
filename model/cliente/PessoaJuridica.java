package loja.model.cliente;

public class PessoaJuridica extends Cliente  implements ICliente {
    public PessoaJuridica(String id, String nome, String endereco, String telefone) {
        super(id, nome, endereco, telefone);
    }

    @Override
    public String getTipo() {
        return "Pessoa Jurídica";
    }
}
