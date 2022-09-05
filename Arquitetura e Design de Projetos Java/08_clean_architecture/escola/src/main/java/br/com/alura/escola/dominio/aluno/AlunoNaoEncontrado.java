package br.com.alura.escola.dominio.aluno;

public class AlunoNaoEncontrado extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AlunoNaoEncontrado(Cpf cpf) {
		super("Aluno não encontrado. CPF " + cpf.getNumero() + " não encontrado.");
	}
}
