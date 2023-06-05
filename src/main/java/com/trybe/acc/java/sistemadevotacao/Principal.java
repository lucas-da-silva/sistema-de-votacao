package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

/**
 * Classe principal que gerencia o fluxo da aplicação.
 * 
 */
public class Principal {

  private static Scanner scanner = new Scanner(System.in);
  private static final short addRegistration = 1;
  private static final short votar = 1;
  private static final short resultadoParcial = 2;

  /**
   * Método principal.
   *
   * @param args parâmetro padrão
   */
  public static void main(String[] args) {
    System.out.println("\n----------- Bem-vindo ao Sistema de Votação -----------\n");
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();

    String pessoa;
    Short candidatoOpcao;

    while (true) {
      pessoa = "candidata";
      Principal.pessoaMenu(pessoa);
      candidatoOpcao = Principal.scanner.nextShort();
      if (candidatoOpcao == Principal.addRegistration) {
        Principal.campoMenu("nome", pessoa);
        String nome = Principal.scanner.next();
        Principal.campoMenu("número", pessoa);
        int numero = Principal.scanner.nextInt();

        gerenciamentoVotacao.cadastrarPessoaCandidata(nome, numero);
        continue;
      } else {
        break;
      }
    }

    System.out.println("\n\n----------- Cadastre as pessoas eleitoras -----------\n");
    Short eleitorOpcao;

    while (true) {
      pessoa = "eleitora";
      Principal.pessoaMenu(pessoa);
      eleitorOpcao = Principal.scanner.nextShort();
      if (eleitorOpcao == Principal.addRegistration) {
        Principal.campoMenu("nome", pessoa);
        String nome = Principal.scanner.next();
        Principal.campoMenu("cpf", pessoa);
        String cpf = Principal.scanner.next();

        gerenciamentoVotacao.cadastrarPessoaEleitora(nome, cpf);
        continue;
      } else {
        break;
      }
    }


    System.out.println("\n\n----------- Votação iniciada! -----------\n");
    Short votacaoOpcao;

    while (true) {
      Principal.votacaoMenu();
      votacaoOpcao = Principal.scanner.nextShort();

      if (votacaoOpcao == Principal.votar) {
        Principal.campoMenu("cpf", "eleitora");
        String cpf = Principal.scanner.next();
        Principal.campoMenu("número", "candidata");
        int numero = Principal.scanner.nextInt();

        gerenciamentoVotacao.votar(cpf, numero);
        continue;
      } else if (votacaoOpcao == Principal.resultadoParcial) {
        gerenciamentoVotacao.mostrarResultado();
        continue;
      } else {
        gerenciamentoVotacao.mostrarResultado();
        break;
      }
    }

    Principal.scanner.close();
  }

  private static void pessoaMenu(String pessoa) {
    System.out.println("Cadastrar pessoa " + pessoa + "?");
    System.out.println(" 1 - Sim");
    System.out.println(" 2 - Não");
    System.out.println("Entre com o número correspondente à opção desejada:");
  }

  private static void campoMenu(String campo, String pessoa) {
    System.out.println("Entre com o " + campo + " da pessoa " + pessoa + ":");
  }

  private static void votacaoMenu() {
    System.out.println("Entre com o número correspondente à opção desejada:");
    System.out.println("1 - Votar");
    System.out.println("2 - Resultado Parcial");
    System.out.println("3 - Finalizar Votação");
  }
}
