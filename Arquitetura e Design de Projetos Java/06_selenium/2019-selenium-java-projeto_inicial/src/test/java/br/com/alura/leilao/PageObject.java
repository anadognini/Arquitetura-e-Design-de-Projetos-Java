package br.com.alura.leilao;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {
	protected WebDriver browser;
	protected static final String URL_FORMULARIO = "http://localhost:8080/leiloes/new";

	public PageObject(WebDriver browser) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		if (browser == null) {
			this.browser = new ChromeDriver();
		} else {
			this.browser = browser;
		}
		
		this.browser.manage().timeouts()
			.implicitlyWait(10, TimeUnit.SECONDS)
			.pageLoadTimeout(5, TimeUnit.SECONDS);
	}

	public void fechar() {
		this.browser.quit();
	}
}
