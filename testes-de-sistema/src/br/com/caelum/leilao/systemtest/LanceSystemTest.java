package br.com.caelum.leilao.systemtest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LanceSystemTest {

	private WebDriver driver;
	private LeiloesPage leiloes;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Ferramental\\chromedriver_win32\\chromedriver.exe");
		this.driver = new ChromeDriver();

		driver.get(new URLDaAplicacao().getUrlBase() + "/apenas-teste/limpa");
		
		leiloes = new CriadorDeCenarios(driver)
				.umUsuario("Paulo Henrique", "paulo@henrique.com")
				.umUsuario("José Alberto", "jose@alberto.com")
				.umLeilao("Paulo Henrique", "Geladeira", 100, false)
				.constroi();

	}

	@After
	public void encerra() {
		driver.close();
	}

	@Test
	public void deveFazerUmLance() {

		DetalhesDoLeilaoPage lances = leiloes.detalhes(1);

		lances.lance("José Alberto", 150);

		assertTrue(lances.existeLance("José Alberto", 150));
	}
}
