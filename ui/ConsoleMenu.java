package loja.ui;

import loja.model.cliente.*;
import loja.model.produto.*;
import loja.model.nota.*;
import loja.ui.Funcoes;

import java.util.Scanner;
import java.math.BigDecimal;
public class ConsoleMenu{

public static void exibirMenu(Scanner sc, Produto [] produtos, ICliente[] clientes, Nota[] notas, int totalProdutos, int totalClientes, int totalNotas){
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Alterar Produto");
            System.out.println("3. Cadastrar Cliente");
            System.out.println("4. Alterar Cliente");
            System.out.println("5. Criar Nota de Compra");
            System.out.println("6. Listar Notas Emitidas");
            System.out.println("7. Listar Produtos");
            System.out.println("8. Listar Clientes");
            System.out.println("0. Sair");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1 -> totalProdutos=Funcoes.cadastrarProduto(sc,produtos,totalProdutos);
                case 2 -> Funcoes.alterarProduto(sc,produtos,totalProdutos);
                case 3 -> totalClientes= Funcoes.cadastrarCliente(sc,clientes,totalClientes);
                case 4 -> Funcoes.alterarCliente(sc,clientes,totalClientes);
                case 5 -> totalNotas=Funcoes.criarNota(sc,notas,totalNotas,clientes,totalClientes,produtos,totalProdutos);
                case 6 -> Funcoes.listarNotas(notas,totalNotas);
                case 7 -> Funcoes.listarProdutos(produtos,totalProdutos);
                case 8 -> Funcoes.listarClientes(clientes,totalClientes);
            }
            
        } while (opcao != 0);
    }
}
