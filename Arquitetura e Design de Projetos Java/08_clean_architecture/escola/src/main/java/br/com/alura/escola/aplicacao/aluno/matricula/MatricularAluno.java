package br.com.alura.escola.aplicacao.aluno.matricula;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;

public class MatricularAluno {
	// Use case
	// Padrão command
	private final RepositorioDeAlunos repositorio;

	public MatricularAluno(RepositorioDeAlunos repositorio) {
		this.repositorio = repositorio;
	}
	
	public void executar(MatricularAlunoDto dados) {
		Aluno novo = dados.criarAluno();
		
		this.repositorio.matricular(novo);
	}
}
