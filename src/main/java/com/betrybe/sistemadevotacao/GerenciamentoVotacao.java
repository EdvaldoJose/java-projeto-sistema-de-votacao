package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 * The type Gerenciamento votacao.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private final ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<>();
  private final ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<>();
  private final ArrayList<String> cpfsComputados = new ArrayList<>();

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata pc : pessoasCandidatas) {
      if (pc.getNumero() == numero) {
        System.out.print("Número da pessoa candidata já utilizado!");
        return;
      }
    }

    pessoasCandidatas.add(new PessoaCandidata(nome, numero));
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (PessoaEleitora pe : pessoasEleitoras) {
      if (pe.getCpf() == cpf) {
        System.out.print("Pessoa eleitora já cadastrada!");
        return;
      }
    }

    pessoasEleitoras.add(new PessoaEleitora(nome, cpf));
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    for (String cpf : cpfsComputados) {
      if (cpf.equals(cpfPessoaEleitora)) {
        System.out.print("Pessoa eleitora já votou!");
        return;
      }
    }

    for (PessoaCandidata pc : pessoasCandidatas) {
      if (pc.getNumero() == numeroPessoaCandidata) {
        pc.receberVoto();
        cpfsComputados.add(cpfPessoaEleitora);
        return;
      }
    }

    System.out.print("Pessoa eleitora ou pessoa candidata não encontrada!");
  }

  @Override
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.print("É preciso ter pelo menos um voto para mostrar o resultado.");
    } else {
      for (PessoaCandidata pc : pessoasCandidatas) {
        System.out.println(
            "Nome: " + pc.getNome()
                + " - " + pc.getVotos() + " votos "
                + "( " + (pc.getVotos() * 100 / cpfsComputados.size()) + "%)"
        );
      }

      System.out.println("Total de votos: " + cpfsComputados.size());
    }
  }
}
