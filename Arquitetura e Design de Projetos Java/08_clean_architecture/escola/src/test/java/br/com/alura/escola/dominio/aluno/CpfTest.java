package br.com.alura.escola.dominio.aluno;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.alura.escola.dominio.aluno.Cpf;

public class CpfTest {

	@Test
	public void naoDeveCriarCpfsInvalidos() {
		assertThrows(IllegalArgumentException.class, () -> new Cpf(null));
		assertThrows(IllegalArgumentException.class, () -> new Cpf(""));
		assertThrows(IllegalArgumentException.class, () -> new Cpf("12345678900"));
	}

	@Test
	public void deveCriarCpfsValidos() {
		String numero = "123.456.789-00";
		
		Cpf cpf = new Cpf(numero);
		
		assertEquals(numero, cpf.getNumero());
	}
}

