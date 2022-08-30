package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
	
	private LoginPage paginaDeLogin;
	
	@BeforeEach
	public void beforerEach() {
		this.paginaDeLogin = new LoginPage();
	}
	
	@AfterEach
	public void afterEach() {
		this.paginaDeLogin.fechar();
	}
	
	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		paginaDeLogin.preencherFormulario("fulano", "pass");
		paginaDeLogin.submeterFormulario();
		
		Assert.assertFalse(paginaDeLogin.verificarPaginaDeLogin());
		Assert.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());
	}
	
	@Test 
	public void naoDeveriaEfetuarLoginComDadosInvalidos() {
		paginaDeLogin.preencherFormulario("invalido", "123123");
		paginaDeLogin.submeterFormulario();
		
		Assert.assertTrue(paginaDeLogin.verificarPaginaDeLoginComDadosInvalidos());
		Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());
		Assert.assertTrue(paginaDeLogin.verificarTexto("Usuário e senha inválidos."));
	}
	
	// Testando uma página restrita
	@Test 
	public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
		paginaDeLogin.navegaParaPaginaDeLances();
		
		Assert.assertTrue(paginaDeLogin.verificarPaginaDeLogin());
		Assert.assertFalse(paginaDeLogin.verificarTexto("Dados do Leilão"));
	}
}