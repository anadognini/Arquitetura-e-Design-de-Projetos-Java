package br.com.alura.escola.dominio.aluno;

public class FabricaDeAluno {
	private Aluno aluno;
	
	public FabricaDeAluno criarAlunoComNomeCpfEmail(String nome, String cpf, String email) {
		this.aluno = new Aluno(new Cpf(cpf), nome, new Email(email));
		
		return this;
	}
	
	public FabricaDeAluno criarAlunoComTelefone (String ddd, String numero) {
		this.aluno.adicionarTelefone(ddd, numero);
		
		return this;
	}
	
	public Aluno criarAluno() {
		return this.aluno;
	}
}
