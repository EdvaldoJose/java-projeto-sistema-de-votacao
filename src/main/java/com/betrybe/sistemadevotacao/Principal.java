package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * The type Principal.
 */
public class Principal {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner scanner = new Scanner(System.in);
    GerenciamentoVotacao votacao = new GerenciamentoVotacao();

    registrarCandidato(scanner, votacao);
    registrarEleitorer(scanner, votacao);
    votar(scanner, votacao);

    scanner.close();
  }

  private static void registrarCandidato(Scanner scanner, GerenciamentoVotacao votacao) {
    while (true) {
      System.out.println("Cadastrar pessoa candidata?\n1 - Sim\n2 - Não");
      System.out.print("Entre com o número correspondente à opção desejada: ");

      short option = scanner.nextShort();

      switch (option) {

        case 1 -> {
          scanner.nextLine();
          System.out.print("Entre com o nome da pessoa candidata: ");
          String nome = scanner.nextLine();
          System.out.print("Entre com o número da pessoa candidata: ");
          int numero = scanner.nextInt();
          votacao.cadastrarPessoaCandidata(nome, numero);
        }

        case 2 -> {
          System.out.println("Finalizando o cadastro d candidatos.");
          return;
        }

        default -> System.out.println("Entre com uma opção válida.");

      }

    }
  }

  private static  void registrarEleitorer(Scanner scanner, GerenciamentoVotacao votacao) {
    while (true) {
      System.out.println("Cadastrar pessoa eleitora?\n1 - Sim\n2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada: ");

      short option = scanner.nextShort();

      switch (option) {

        case 1 -> {
          scanner.nextLine();
          System.out.println("Entre com o nome da pessoa eleitora: ");
          String nome = scanner.nextLine();
          System.out.println("Entre com o CPF da pessoa eleitora: ");
          String cpf = scanner.nextLine();
          votacao.cadastrarPessoaEleitora(nome, cpf);
        }

        case 2 -> {
          System.out.println("Finalizando cadastro de eleitores.");
          return;
        }

        default -> System.out.println("Entre com uma opção válida.");
      }
    }
  }

  private static void votar(Scanner scanner, GerenciamentoVotacao votacao) {
    while (true) {
      System.out.println(
          """
              Entre com o número correspondente à opção desejada:
              1 - Votar
              2 - Resultado Parcial
              3 - Finalizar Votação"""
      );

      short option = scanner.nextShort();

      switch (option) {

        case 1 -> {
          scanner.nextLine();
          System.out.print("Entre com o cpf da pessoa eleitora: ");
          String cpfsPessoaEleitora = scanner.nextLine();
          System.out.println("Entre com o número da pessoa candidata: ");
          int numeroPessoaCandidata = scanner.nextInt();
          votacao.votar(cpfsPessoaEleitora, numeroPessoaCandidata);
        }

        case 2 -> {
          System.out.println("Resultado parcial");
          votacao.mostrarResultado();
        }

        case 3 -> {
          System.out.println("Finalizar Votação");
          votacao.mostrarResultado();
          return;
        }

        default -> System.out.println("Entre com uma opção válida.");
      }
    }
  }

}
