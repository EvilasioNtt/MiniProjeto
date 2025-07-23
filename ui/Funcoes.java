package loja.ui;

import loja.model.cliente.*;
import loja.model.produto.*;
import loja.model.nota.*;
  
import java.util.Scanner;
import java.math.BigDecimal;

public class Funcoes{

    public static int cadastrarProduto(Scanner sc, Produto[] produtos, int totalProdutos) {
        System.out.print("Código do produto: ");
        String codigo = sc.nextLine();
        System.out.println("Tipo (1-Físico, 2-Digital, 3-Perecível): ");
        int tipo = Integer.parseInt(sc.nextLine());
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Preço: ");
        BigDecimal preco = new BigDecimal(sc.nextLine());
        System.out.print("Estoque: ");
        int estoque = Integer.parseInt(sc.nextLine());

        Produto p = switch (tipo) {
            case 1 -> new ProdutoFisico(codigo, nome, preco, estoque);
            case 2 -> new ProdutoDigital(codigo, nome, preco, estoque);
            case 3 -> new ProdutoPerecivel(codigo, nome, preco, estoque);
            default -> null;
        };

        if (p != null && totalProdutos < produtos.length) {
            Produto produtoUpcast= (Produto) p;
            produtos[totalProdutos++] = p;
            System.out.println("Produto cadastrado com sucesso.");
        }
        return totalProdutos;
    }

    public static void alterarProduto(Scanner sc, Produto[] produtos, int totalProdutos) {
        listarProdutos(produtos,totalProdutos);
        System.out.print("Digite o código do produto a alterar: ");
        String codigo = sc.nextLine();

        for (int i = 0; i < totalProdutos; i++) {
            if (produtos[i].getCodigo().equals(codigo)) {
                System.out.print("Novo nome: ");
                produtos[i].setNome(sc.nextLine());
                System.out.print("Novo preço: ");
                produtos[i].setPreco(new BigDecimal(sc.nextLine()));
                System.out.print("Novo estoque: ");
                produtos[i].setEstoque(Integer.parseInt(sc.nextLine()));

              if (produtos[i] instanceof ProdutoFisico){
                ProdutoFisico fisico = (ProdutoFisico) produtos[i];
                System.out.println ("(Downcast aplicado com sucesso: Produto é fisico)");
              }
                System.out.println("Produto alterado com sucesso.");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    public static int cadastrarCliente(Scanner sc,Cliente[] clientes, int totalClientes) {
        System.out.print("ID do cliente: ");
        String id = sc.nextLine();
        System.out.println("Tipo (1-Física, 2-Jurídica): ");
        int tipo = Integer.parseInt(sc.nextLine());
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Endereço: ");
        String endereco = sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        Cliente c = (tipo == 1) ? new PessoaFisica(id, nome, endereco, telefone)
                                : new PessoaJuridica(id, nome, endereco, telefone);

        if (totalClientes < clientes.length) {
            clientes[totalClientes++] = c;
            System.out.println("Cliente cadastrado com sucesso.");
        }
        return totalClientes;
    }

    public static void alterarCliente(Scanner sc,Cliente[] clientes, int totalClientes) {
        listarClientes(clientes, totalClientes);
        System.out.print("ID do cliente a alterar: ");
        String id = sc.nextLine();

        for (int i = 0; i < totalClientes; i++) {
            if (clientes[i].getId().equals(id)) {
                System.out.print("Novo nome: ");
                clientes[i].setNome(sc.nextLine());
                System.out.print("Novo endereço: ");
                clientes[i].setEndereco(sc.nextLine());
                System.out.print("Novo telefone: ");
                clientes[i].setTelefone(sc.nextLine());
                System.out.println("Cliente alterado com sucesso.");
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }

    public static int criarNota(Scanner sc,Nota[] notas, int totalNotas,Cliente[]clientes,int totalClientes,Produto[] produtos,int totalProdutos) {
        listarClientes(clientes,totalClientes);
        System.out.print("ID do cliente: ");
        String id = sc.nextLine();

        Cliente cliente = null;
        for (int i = 0; i < totalClientes; i++) {
            if (clientes[i].getId().equals(id)) {
                cliente = clientes[i];
                break;
            }
        }

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return totalNotas;
        }

        Nota nota = new Nota(cliente);

        while (true) {
            listarProdutos(produtos,totalProdutos);
            System.out.print("Código do produto (0 para finalizar): ");
            String codigo = sc.nextLine();
            if (codigo.equals("0")) break;

            Produto produto = null;
            for (int i = 0; i < totalProdutos; i++) {
                if (produtos[i].getCodigo().equals(codigo)) {
                    produto = produtos[i];
                    break;
                }
            }

            if (produto == null) {
                System.out.println("Produto não encontrado.");
                continue;
            }

            System.out.print("Quantidade: ");
            int qtd = Integer.parseInt(sc.nextLine());
            if (qtd <= produto.getEstoque()) {
                produto.setEstoque(produto.getEstoque() - qtd);
                nota.adicionarItem(new ItemNota(produto, qtd));
            } else {
                System.out.println("Estoque insuficiente!");
            }
        }

        if (totalNotas < notas.length) {
            notas[totalNotas++] = nota;
            System.out.println("Nota criada com sucesso.");
            nota.exibirResumo();
        }
        return totalNotas;
    }

    public static void listarNotas(Nota[] notas, int totalNotas) {
        for (int i = 0; i < totalNotas; i++) {
            notas[i].exibirResumo();
            System.out.println("---------------------");
        }
    }

    public static void listarProdutos(Produto[] produtos, int totalProdutos) {
        for (int i = 0; i < totalProdutos; i++) {
            Produto p = produtos[i];
            System.out.println("[" + p.getCodigo() + "] " + p.getNome() + " | " + p.getTipo() + " | R$ " + p.getPreco() + " | Estoque: " + p.getEstoque());
        }
    }

    public static void listarClientes(Cliente[] clientes, int totalClientes) {
        for (int i = 0; i < totalClientes; i++) {
            Cliente c = clientes[i];
            System.out.println("[" + c.getId() + "] " + c.getNome() + " | " + c.getTipo() + " | " + c.getTelefone());
        }
    }
}
