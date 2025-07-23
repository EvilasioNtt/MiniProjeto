package loja;

import loja.model.cliente.*;
import loja.model.produto.*;
import loja.model.nota.*;
import loja.ui.ConsoleMenu;
import loja.ui.Funcoes;

import java.util.Scanner;
import java.io.Console;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         Produto[] produtos = new Produto[100];
         int totalProdutos=0;
         ICliente[] clientes = new ICliente[100];
         int totalClientes=0;
         Nota[] notas = new Nota[100];
         int totalNotas=0;

        ConsoleMenu.exibirMenu(sc,produtos,clientes,notas,totalProdutos,totalClientes,totalNotas);

        sc.close();
    }
}
