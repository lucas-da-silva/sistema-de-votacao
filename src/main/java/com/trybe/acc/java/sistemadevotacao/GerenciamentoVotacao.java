package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

/**
 * Classe responsável por gerenciar a votação.
 */
public class GerenciamentoVotacao {

  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfComputado = new ArrayList<String>();
  private ArrayList<Integer> numerosCadastrados = new ArrayList<Integer>();
  private ArrayList<String> cpfCadastrados = new ArrayList<String>();
  private int totalVotos = 0;

  /**
   * Método responsável por cadastrar uma PessoaCandidata.
   *
   * @param nome nome da pessoa candidata
   * @param numero numero da pessoa candidata
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    if (this.numerosCadastrados.contains(numero)) {
      System.out.println("Número pessoa candidata já utilizado!");
    } else {
      PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
      this.pessoasCandidatas.add(pessoaCandidata);
      this.numerosCadastrados.add(numero);
    }
  }

  /**
   * Método responsável por cadastrar uma PessoaEleitora.
   *
   * @param nome nome da pessoa eleitora
   * @param cpf cpf da pessoa eleitora
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    if (this.cpfCadastrados.contains(cpf)) {
      System.out.println("Pessoa eleitora já cadastrada!");
    } else {
      PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
      this.pessoasEleitoras.add(pessoaEleitora);
      this.cpfCadastrados.add(cpf);
    }
  }

  /**
   * Método responsável pela votação, chamando o método receberVoto da PessoaCandidata.
   *
   * @param cpfPessoaEleitora cpf da pessoa eleitora
   * @param numeroPessoaCandidata numero da pessoa candidata
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (this.cpfComputado.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
    } else {

      for (PessoaCandidata pessoaCandidata : this.pessoasCandidatas) {
        if (pessoaCandidata.getNumero() == numeroPessoaCandidata) {
          pessoaCandidata.receberVoto();
        }
      }

      this.cpfComputado.add(cpfPessoaEleitora);
      this.totalVotos += 1;
    }
  }

  /**
   * Método responsável por cadastrar uma PessoaCandidata.
   */
  public void mostrarResultado() {
    if (totalVotos > 0) {
      for (int i = 0; i < this.pessoasCandidatas.size(); i++) {
        double porcentagemVotos = this.calcularPorcentagemVotos(i);
        PessoaCandidata pessoaCandidata = this.pessoasCandidatas.get(i);

        System.out.print("Nome: " + pessoaCandidata.getNome() + " - ");
        System.out.println(pessoaCandidata.getVotos() + " votos ( " + porcentagemVotos + "% )");
      }

      System.out.println("Total de votos: " + this.totalVotos);
    } else {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    }
  }

  private double calcularPorcentagemVotos(int indiceCandidato) {
    PessoaCandidata pessoaCandidata = this.pessoasCandidatas.get(indiceCandidato);
    double porcentagemVotos = ((double) pessoaCandidata.getVotos() / this.totalVotos) * 100;
    return Math.round(porcentagemVotos);
  }
}
