package br.com.alura.escola.aplicacao.aluno.matricula;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.Cpf;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoTest {

	@Test
	public void alunoDeveSerPersistido() {
		// MOCK -> Mockito
		
		RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
		MatricularAluno useCase = new MatricularAluno(repositorio);
		
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
