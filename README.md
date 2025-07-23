# Integrantes 
Evilásio Cavalcante de Melo Neto
Júlio César Pereira Nascimento
Lucas da Silva Rodrigues


# Sistema de Loja - Projeto Java Orientado a Objetos

Este projeto implementa um sistema de loja com funcionalidades de cadastro de produtos e clientes, emissão de notas fiscais de compra e controle de estoque. O sistema foi desenvolvido em Java utilizando os pilares da Programação Orientada a Objetos: encapsulamento, herança, polimorfismo e associação de classes.

## Funcionalidades

- Cadastrar produtos (Físico, Digital, Perecível)
- Alterar dados de produtos (nome, preço, estoque)
- Cadastrar clientes (Pessoa Física e Jurídica)
- Alterar dados de clientes
- Criar nota de compra
- Listar notas emitidas
- Listar todos os produtos
- Listar todos os clientes

## Técnicas aplicadas

- Encapsulamento, herança e polimorfismo
- Agregação (cliente → nota, nota → itens)
- Uso de `BigDecimal` para precisão em valores monetários
- Uso de `LocalDateTime` para registrar a data da nota
- Upcast e Downcast aplicados de forma didática
- Armazenamento de dados em arrays simples (`Produto[]`, `Cliente[]`, etc.) — sem uso de coleções (`ArrayList`)

## Estrutura de pacotes

```
loja/
├── Main.java
└── model/
    ├── cliente/
    │   ├── Cliente.java
    │   ├── PessoaFisica.java
    │   └── PessoaJuridica.java
    ├── nota/
    │   ├── Nota.java
    │   └── ItemNota.java
    └── produto/
        ├── Produto.java
        ├── ProdutoFisico.java
        ├── ProdutoDigital.java
        └── ProdutoPerecivel.java
```

## Como executar

1. Certifique-se de estar no diretório acima da pasta `loja/`.
2. Compile o projeto:

```bash
javac loja/Main.java
```

3. Execute:

```bash
java loja.Main
```

## Observações

- O sistema roda via terminal (CLI).
- O código é modularizado e pensado para facilitar manutenção.
- Identificadores de produtos e clientes são `String`, não números.

## Requisitos

- Java 17 ou superior

---

Desenvolvido como parte de atividade prática para consolidar os conceitos fundamentais de POO em Java.

## Comparação e Adição de Upcast e Downcast

O sistema foi estendido com um exemplo didático de upcast e downcast, como requisito adicional da atividade.

### Antes
Anteriormente, ao cadastrar produtos ou alterar produtos, não havia conversão de tipos entre as superclasses e subclasses. Exemplo direto:

```java
Produto p = new ProdutoFisico(...);
produtos[i] = p;
```

### Depois (com casts)
Agora, foi implementado:

#### Upcast (de `ProdutoFisico` para `Produto`)
Mesmo que em Java o upcast seja implícito, foi feito de forma explícita como exemplo didático:

```java
Produto produtoUpcast = (Produto) p;
produtos[totalProdutos++] = produtoUpcast;
```

#### Downcast (de `Produto` para `ProdutoFisico`)
Verificamos se um produto é instância de `ProdutoFisico` antes de fazer o cast:

```java
if (produtos[i] instanceof ProdutoFisico) {
    ProdutoFisico fisico = (ProdutoFisico) produtos[i];
    System.out.println("(Downcast aplicado com sucesso: Produto é físico)");
}
```

Esses exemplos ilustram como o Java permite manipular tipos mais genéricos e, quando necessário, retornar ao tipo específico.

---

## Uso de Tipos Abstratos e Herança

O projeto foi projetado com superclasses abstratas que representam os conceitos genéricos:

### Produtos
- `Produto` (abstrata): define os atributos e comportamentos comuns a todos os produtos (`codigo`, `nome`, `preco`, `estoque`).
- Subclasses concretas:
  - `ProdutoFisico`
  - `ProdutoDigital`
  - `ProdutoPerecivel`

### Clientes
- `Cliente` (abstrata): contém os dados básicos e método `getTipo()`.
- Subclasses concretas:
  - `PessoaFisica`
  - `PessoaJuridica`

### Notas
- `Nota` agrega vários `ItemNota` e calcula o total com `BigDecimal`.
- `ItemNota` associa um `Produto` a uma quantidade comprada.

Esse uso de tipos abstratos permite aplicar polimorfismo, onde manipulamos produtos e clientes por suas interfaces comuns, mas preservamos o comportamento específico nas subclasses.

### Nova Estrutura

Seguindo uma sugestão do professor, o projeto foi refatorado para separar a interface do usuário da lógica de negócio. Isso melhora a organização do código e facilita futuras manutenções.

Uma nova pasta foi criada:

```
loja/
├── ui/
│   ├── ConsoleMenu.java  # Contém o menu principal e loop de execução
│   └── Funcoes.java      # Contém as funções de cadastro, alteração e listagens
```

### O que mudou?

#### `Main.java` antes:

- Continha toda a lógica de menu e funções.

#### `Main.java` agora:

```java
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Produto[] produtos = new Produto[100];
        Cliente[] clientes = new Cliente[100];
        Nota[] notas = new Nota[100];
        // Totais como variáveis locais
        ConsoleMenu.exibirMenu(sc, produtos, clientes, notas, totalProdutos, totalClientes, totalNotas);
        sc.close();
    }
}
```

#### `ConsoleMenu.java`

Responsável apenas por mostrar o menu principal e redirecionar as opções para a classe `Funcoes`.

#### `Funcoes.java`

Agrupa todas as funcionalidades do sistema: cadastrar/alterar produtos e clientes, criar nota, e listar registros.

- Melhor separação de responsabilidades
- Facilita testes e manutenção
- Código principal (`Main`) fica limpo e legível


### Uso de Interfaces e Polimorfismo
O projeto utiliza da interface denominada ICliente para:
Definir o contrato String getTipo().
A classe abstrata Cliente implementa ICliente, e suas subclasses, PessoaFisica e PessoaJuridica, fornecem a implementação concreta para o método getTipo().
Isso permite que arrays e métodos que esperam um ICliente possam manipular tanto objetos PessoaFisica quanto PessoaJuridica de forma uniforme.
O motivo para utilização da interface ICliente no lugar da classe cliente é garantir o polimorfismo, tornar os tipos mais genéricos e tornar o código mais fácil de estender.
Para garantir a utilização adequada da interface alteramos as funções que utilizavam objetos da classe Cliente para utilizar objetos ICliente.
