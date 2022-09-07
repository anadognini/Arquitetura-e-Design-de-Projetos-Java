package br.com.alura.escola.academico.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.escola.shared.dominio.Cpf;

public class Aluno {
	private Cpf cpf;
	private String nome;
	private Email email;
	private List<Telefone> telefones = new ArrayList<>();
	private String senha;

	public Aluno(Cpf cpf, String nome, Email email) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}

	public Cpf getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email.getEndereco();
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void adicionarTelefone(String ddd, String numero) {
		if (telefones.size() == 2) {
			throw new IllegalArgumentException("O número máximo de telefones já foi atingido.");
		}

		this.telefones.add(new Telefone(ddd, numero));
	}
}

// Alt + Shift + S
//Entidade -> classe que possui um atributo que idenfique unicamente o objeto

/*
 * Uma entidade formada por um conjunto de value objects é um aggregate root. É
 * preciso ter cuidado com situações assim. Todo o acesso a esses value objects
 * deve ser feito pela classe root.
 */