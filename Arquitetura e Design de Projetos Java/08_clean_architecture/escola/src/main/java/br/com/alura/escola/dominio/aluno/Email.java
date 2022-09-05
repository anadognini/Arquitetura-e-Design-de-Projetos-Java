package br.com.alura.escola.dominio.aluno;

public class Email {
	// Value object -> classe que não tem como diferenciar duas instâncias.
	// Se dois objetos tiverem o mesmo valor, é o mesmo objeto
	// https://martinfowler.com/bliki/ValueObject.html

	private String endereco;

	public Email(String endereco) {
		if (endereco == null || !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
			throw new IllegalArgumentException("E-mail inválido.");
		}

		this.endereco = endereco;
	}

	public String getEndereco() {
		return endereco;
	}
}
