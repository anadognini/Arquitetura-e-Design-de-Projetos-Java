package br.com.alura.escola.dominio.aluno;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

import br.com.alura.escola.academico.dominio.aluno.Email;

public class EmailTest {

	@Test
	public void naoDeveCriarEmailsInvalidos() {
		assertThrows(IllegalArgumentException.class, () -> new Email(null));
		assertThrows(IllegalArgumentException.class, () -> new Email(""));
		assertThrows(IllegalArgumentException.class, () -> new Email("emailinvalido"));
	}

	@Test
	public void deveCriarEmailsValidos() {
		String endereco = "email@email.com";
		
		Email email = new Email(endereco);
		
		assertEquals(endereco, email.getEndereco());
	}
}
