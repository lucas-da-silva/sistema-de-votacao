package com.acc.java.sistemadevotacao;

/**
 * Classe abstrata com a assinatura dos métodos que devem ser implementados.
 */
public abstract class Pessoa {
  protected String nome;

  public Pessoa(String nome) {
    this.nome = nome;
  }

  public abstract String getNome();

  public abstract void setNome(String nome);
}
