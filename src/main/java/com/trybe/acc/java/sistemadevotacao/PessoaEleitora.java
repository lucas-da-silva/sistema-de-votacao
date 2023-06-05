package com.trybe.acc.java.sistemadevotacao;

/**
 * Classe que implementa a classe abstrata Pessoa e constroi um objeto PessoEleitora.
 */
public class PessoaEleitora extends Pessoa {
  private String cpf;

  public PessoaEleitora(String nome, String cpf) {
    super(nome);
    this.cpf = cpf;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getNome() {
    return super.nome;
  }

  public void setNome(String nome) {
    super.nome = nome;
  }
}
