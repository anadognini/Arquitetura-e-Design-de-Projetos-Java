package br.com.alura.escola;

import br.com.alura.escola.academico.aplicacao.aluno.matricula.MatricularAluno;
import br.com.alura.escola.academico.aplicacao.aluno.matricula.MatricularAlunoDto;
import br.com.alura.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;
import br.com.alura.escola.gamificacao.aplicacao.GerarSeloAlunoNovato;
import br.com.alura.escola.gamificacao.infra.selo.RepositorioDeSelosEmMemoria;
import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;

public class MatricularAlunoViaLinhaDeComando {
	public static void main(String[] args) {
		String nome = "Fulano da Silva";
		String cpf = "123.456.789-00";
		String email = "email@email.com";
		
		MatricularAlunoDto dto = new MatricularAlunoDto(nome, cpf, email);
		
		RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
		RepositorioDeSelosEmMemoria repositorioDeSelos = new RepositorioDeSelosEmMemoria();
		
		PublicadorDeEventos publicador = new PublicadorDeEventos();
		publicador.adicionar(new LogDeAlunoMatriculado());
		publicador.adicionar(new GerarSeloAlunoNovato(repositorioDeSelos));
		
		MatricularAluno matricula = new MatricularAluno(repositorio, publicador);
		matricula.executar(dto);
	}
}
