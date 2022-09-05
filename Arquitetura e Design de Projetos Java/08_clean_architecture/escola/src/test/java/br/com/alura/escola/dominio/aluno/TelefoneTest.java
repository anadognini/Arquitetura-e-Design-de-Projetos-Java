package br.com.alura.escola.dominio.aluno;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.alura.escola.dominio.aluno.Telefone;

public class TelefoneTest {

	@Test
	public void naoDeveCriarTelefonesComDDDsInvalidos() {
		assertThrows(IllegalArgumentException.class, () -> new Telefone(null, "123456789"));
		assertThrows(IllegalArgumentException.class, () -> new Telefone("", "123456789"));
		assertThrows(IllegalArgumentException.class, () -> new Telefone("0", "123456789"));
	}
	
	@Test
	public void naoDeveCriarTelefonesComNumerosInvalidos() {
		assertThrows(IllegalArgumentException.class, () -> new Telefone("47", null));
		assertThrows(IllegalArgumentException.class, () -> new Telefone("47", ""));
		assertThrows(IllegalArgumentException.class, () -> new Telefone("47", "12345"));
	}
	
	@Test
	public void deveCriarTelefonesInvalidos() {
		String ddd = "47";
		String numero = "123456789";
		
		Telefone telefone = new Telefone(ddd, numero);
		
		assertEquals(ddd, telefone.getDdd());
		assertEquals(numero, telefone.getNumero());
	}
}