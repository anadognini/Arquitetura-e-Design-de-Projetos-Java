package br.com.alura.escola.dominio.aluno;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.Email;
import br.com.alura.escola.shared.dominio.Cpf;

public class AlunoTest {
	
	private Aluno aluno;

	@BeforeEach
	public void beforeEach() {
		this.aluno = new Aluno (new Cpf("123.456.789-00"), "Fulano", new Email("email@email.com"));
	}
	
	@Test
	public void devePermitirAdicionar1Telefone() {
		this.aluno.adicionarTelefone("47", "123456789");
		
		assertEquals(1, this.aluno.getTelefones().size());
	}
	
	@Test 
	public void devePermitirAdicionar2Telefones() {
		this.aluno.adicionarTelefone("47", "123456789");
		this.aluno.adicionarTelefone("47", "987654321");
		
		assertEquals(2, this.aluno.getTelefones().size());
	}
	
	@Test
	public void naoDevePermitirAdicionarMaisDe2Telefones() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.aluno.adicionarTelefone("47", "123456789");
			this.aluno.adicionarTelefone("47", "987654321");
			this.aluno.adicionarTelefone("47", "999999999");
		});
	}

}
