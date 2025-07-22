package loja.model.nota;

import loja.model.cliente.Cliente;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Nota {
    private static int contador = 1;

    private int numero;
    private Cliente cliente;
    private ItemNota[] itens;
    private LocalDateTime data;
    private int tamanho;

    public Nota(Cliente cliente) {
        this.numero = contador++;
        this.cliente = cliente;
        this.itens = new ItemNota[100];
        this.data = LocalDateTime.now();
        this.tamanho = 0;
    }

    public void adicionarItem(ItemNota item) {
        if (tamanho < itens.length) {
            itens[tamanho++] = item;
        }
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (int i = 0; i < tamanho; i++) {
            total = total.add(itens[i].getSubtotal());
        }
        return total;
    }

    public void exibirResumo() {
        System.out.println("Nota #" + numero);
        System.out.println("Cliente: " + cliente.getNome());
        for (int i = 0; i < tamanho; i++) {
            ItemNota item = itens[i];
            System.out.println("- " + item.getProduto().getNome() + " x" + item.getQuantidade() + " = R$ " + item.getSubtotal());
        }
        System.out.println("Total: R$ " + getTotal());
        System.out.println("Data: " + data);
    }
}
