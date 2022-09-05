package br.com.alura.escola;

import br.com.alura.escola.aplicacao.aluno.matricula.MatricularAluno;
import br.com.alura.escola.aplicacao.aluno.matricula.MatricularAlunoDto;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoViaLinhaDeComando {
	public static void main(String[] args) {
		String nome = "Fulano da Silva";
		String cpf = "123.456.789-00";
		String email = "email@email.com";

		MatricularAluno matricula = new MatricularAluno(new RepositorioDeAlunosEmMemoria());
		matricula.executar(new MatricularAlunoDto(nome, cpf, email));
	}
}
