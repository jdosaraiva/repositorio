package br.com.caelum.leilao.systemtest;

import org.openqa.selenium.WebDriver;

public class CriadorDeCenarios {

	private WebDriver driver;
	private LeiloesPage leiloes;

	public CriadorDeCenarios(WebDriver driver) {
		this.driver = driver;
	}

	public CriadorDeCenarios umUsuario(String nome, String email) {
		UsuariosPage usuarios = new UsuariosPage(driver);
		usuarios.visita();
		usuarios.novo().cadastra(nome, email);

		return this;
	}

	public CriadorDeCenarios umLeilao(String usuario, String produto,
			double valor, boolean usado) {
		leiloes = new LeiloesPage(driver);
		leiloes.visita();
		leiloes.novo().preenche(produto, valor, usuario, usado);

		return this;
	}
	
	public LeiloesPage constroi() {
		return this.leiloes;
	}
}
