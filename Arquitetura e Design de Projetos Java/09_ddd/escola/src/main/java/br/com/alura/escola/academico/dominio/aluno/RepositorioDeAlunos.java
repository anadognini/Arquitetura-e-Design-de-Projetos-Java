package br.com.alura.escola.academico.dominio.aluno;

import java.util.List;

import br.com.alura.escola.shared.dominio.Cpf;

public interface RepositorioDeAlunos {
	// Método para salvar no banco de dados
	void matricular(Aluno aluno);
	
	Aluno buscarPorCpf(Cpf cpf);
	
	List<Aluno> listarAlunosMatriculados();
}
