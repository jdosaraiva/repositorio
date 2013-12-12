package br.com.caelum.leilao.systemtest;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeiloesSystemTest {

	private WebDriver driver;
	private LeiloesPage leiloes;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Ferramental\\chromedriver_win32\\chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.get("localhost:8080/apenas-teste/limpa");
		
		leiloes = new LeiloesPage(driver);
		
		UsuariosPage usuarios = new UsuariosPage(driver);
		usuarios.visita();
		usuarios.novo().cadastra("Paulo Henrique", "paulo@henrique.com");
	}

	@After
	public void encerra() {
		driver.close();
	}

	@Test
	public void deveCadastrarUmLeilao() {

		leiloes.visita();
		NovoLeilaoPage novoLeilao = leiloes.novo();
		novoLeilao.preenche("Geladeira", 123, "Paulo Henrique", true);

		assertTrue(leiloes.existe("Geladeira", 123, "Paulo Henrique", true));

	}
	
	@Test
	public void naoDeveCadastrarLeilaoSemNomeOuValorInicial() {

		leiloes.visita();
		NovoLeilaoPage novoLeilao = leiloes.novo();
		novoLeilao.preenche("", 0, "Paulo Henrique", true);

		assertTrue(novoLeilao.validaNome());
		assertTrue(novoLeilao.validaValorInicial());
		
	}

}
