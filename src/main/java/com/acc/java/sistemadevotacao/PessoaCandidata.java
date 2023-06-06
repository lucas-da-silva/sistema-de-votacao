package com.acc.java.sistemadevotacao;


/**
 * Classe que implementa a classe abstrata Pessoa e constroi um objeto PessoaCandidata.
 */
public class PessoaCandidata extends Pessoa {

  private int numero;
  private int votos;

  /**
   * Construtor da classe PessoaCandidata.
   *
   * @param nome nome da pessoa
   * @param numero numero da pessoa
   */
  public PessoaCandidata(String nome, int numero) {
    super(nome);
    this.numero = numero;
    this.votos = 0;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  public void setVotos(int votos) {
    this.votos = votos;
  }

  public void receberVoto() {
    this.votos += 1;
  }

  public String getNome() {
    return super.nome;
  }

  public void setNome(String nome) {
    super.nome = nome;
  }
}
