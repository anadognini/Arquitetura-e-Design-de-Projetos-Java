package br.com.alura.escola.dominio.aluno;

import java.util.List;

public interface RepositorioDeAlunos {
	// Método para salvar no banco de dados
	void matricular(Aluno aluno);
	
	Aluno buscarPorCpf(Cpf cpf);
	
	List<Aluno> listarAlunosMatriculados();
}
