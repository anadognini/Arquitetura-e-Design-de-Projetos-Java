package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alura.leilao.PageObject;

public class LeiloesPage extends PageObject {
	private static final String URL_LEILOES = "http://localhost:8080/leiloes";

	public LeiloesPage(WebDriver browser) {
		super(browser);
	}

	public CadastroLeilaoPage carregarFormulario() {
		this.browser.navigate().to(URL_FORMULARIO);
		return new CadastroLeilaoPage(browser);
	}

	public boolean isLeilaoCadastrado(String nome, String valorInicial, String dataAbertura) {
		WebElement ultimaLinhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));

		WebElement colunaComNome = ultimaLinhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
		WebElement colunaComValor = ultimaLinhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
		WebElement colunaComData = ultimaLinhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));

		return colunaComNome.getText().equals(nome) 
				&& colunaComValor.getText().equals(valorInicial)
				&& colunaComData.getText().equals(dataAbertura);
	}

	public boolean estaNaPaginaAtual() {
		return browser.getCurrentUrl().equals(URL_LEILOES);
	}
}