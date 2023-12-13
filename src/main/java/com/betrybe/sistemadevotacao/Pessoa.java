package com.betrybe.sistemadevotacao;

/**
 * The type Pessoa.
 */
public abstract class Pessoa {
  private String nome;

  /**
   * Instantiates a new Pessoa.
   */
  public Pessoa() {

  }

  public Pessoa(String nome) {
    this.nome = nome;
  }

  /**
   * Gets nome.
   *
   * @return the nome
   */
  public String getNome() {
    return nome;
  }

  /**
   * Sets nome.
   *
   * @param nome the nome
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

}
