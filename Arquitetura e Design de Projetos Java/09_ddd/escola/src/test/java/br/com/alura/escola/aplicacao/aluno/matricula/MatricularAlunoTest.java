package br.com.alura.escola.aplicacao.aluno.matricula;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.alura.escola.academico.aplicacao.aluno.matricula.MatricularAluno;
import br.com.alura.escola.academico.aplicacao.aluno.matricula.MatricularAlunoDto;
import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;
import br.com.alura.escola.shared.dominio.Cpf;
import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;

public class MatricularAlunoTest {

	@Test
	public void alunoDeveSerPersistido() {
		// MOCK -> Mockito
		
		RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
		PublicadorDeEventos publicador = new PublicadorDeEventos();
		publicador.adicionar(new LogDeAlunoMatriculado());
		
		MatricularAluno useCase = new MatricularAluno(repositorio, publicador);
		
		String nomeAluno = "Fulano";
		String cpfAluno = "123.456.789-00";
		String emailAluno = "email@email.com";
		
		MatricularAlunoDto dados = new MatricularAlunoDto(nomeAluno, cpfAluno, emailAluno);
		useCase.executar(dados);
		
		Aluno encontrado = repositorio.buscarPorCpf(new Cpf(cpfAluno));
		
		assertEquals("Fulano", encontrado.getNome());
		assertEquals("123.456.789-00", encontrado.getCpf());
		assertEquals("email@email.com", encontrado.getEmail());
	}

}
