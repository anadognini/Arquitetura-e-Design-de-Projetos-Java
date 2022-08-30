package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leiloes.LeiloesPage;

public class LoginPage extends PageObject {
	private static final String URL_LOGIN = "http://localhost:8080/login";
	private static final String URL_LOGIN_ERROR = "http://localhost:8080/login?error";
	private static final String URL_RESTRITA = "http://localhost:8080/leiloes/2";

	public LoginPage() {
		super(null);
		browser.navigate().to(URL_LOGIN);
	}

	public void preencherFormulario(String username, String password) {
		browser.findElement(By.id("username")).sendKeys(username);
		browser.findElement(By.id("password")).sendKeys(password);
	}

	public LeiloesPage submeterFormulario() {
		browser.findElement(By.id("login-form")).submit();
		
		return new LeiloesPage(browser);
	}

	public boolean verificarPaginaDeLogin() {
		return browser.getCurrentUrl().equals(URL_LOGIN);
	}
	
	public boolean verificarPaginaDeLoginComDadosInvalidos() {
		return browser.getCurrentUrl().equals(URL_LOGIN_ERROR);
	}

	public String getNomeUsuarioLogado() {
		try {
			return browser.findElement(By.id("usuario-logado")).getText();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public void navegaParaPaginaDeLances() {
		this.browser.navigate().to(URL_RESTRITA);
	}

	public boolean verificarTexto(String texto) {
		return browser.getPageSource().contains(texto);
	}
}