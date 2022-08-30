package br.com.alura.leilao.leiloes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.login.LoginPage;

public class LeiloesTest {
	
	private LeiloesPage paginaDeLeiloes;
	private CadastroLeilaoPage paginaDeCadastro;
	
	@BeforeEach
	public void beforeEach() {
		LoginPage paginaDeLogin = new LoginPage();
		
		paginaDeLogin.preencherFormulario("fulano", "pass");
		this.paginaDeLeiloes = paginaDeLogin.submeterFormulario();
		this.paginaDeCadastro = paginaDeLeiloes.carregarFormulario();	
	}
	
	@AfterEach
	public void afterEach() {
		this.paginaDeLeiloes.fechar();
	}
	
	@Test
	public void deveriaCadastrarLeilao() {
		String dataAbertura = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String nome = "Leilao do dia" + dataAbertura;
		String valorInicial = "500.00";
		
		this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeialo(nome, valorInicial, dataAbertura);
		
		Assert.assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, valorInicial, dataAbertura));
	}
	
	@Test 
	public void deveriaValidarCadastroDeLeilao() {
		this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeialo("", "", "");
		
		Assert.assertFalse(this.paginaDeCadastro.estaNaPaginaAtual());
		Assert.assertTrue(this.paginaDeLeiloes.estaNaPaginaAtual());
		Assert.assertTrue(this.paginaDeCadastro.isMensagemDeValidacaoVisivel());
	}
}