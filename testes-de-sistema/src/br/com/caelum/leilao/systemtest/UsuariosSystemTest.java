package br.com.caelum.leilao.systemtest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsuariosSystemTest {

	private WebDriver driver;
	private UsuariosPage usuarios;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Ferramental\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("localhost:8080/apenas-teste/limpa");
		
		this.usuarios = new UsuariosPage(driver);
	}

	@Test
	public void deveAdicionarUmUsuario() {

		usuarios.visita();
		usuarios.novo().cadastra("Ronaldo Luiz de Albuquerque",
				"ronaldo2009@terra.com.br");

		assertTrue(usuarios.existeNaListagem("Ronaldo Luiz de Albuquerque",
				"ronaldo2009@terra.com.br"));

	}

	@Test
	public void deveExibirErroParaUsuarioSemNome() {
		usuarios.visita();

		usuarios.novo().cadastra("", "noname@nameless.com");

		assertTrue(usuarios.usuarioObrigatorio());

	}

	@Test
	public void deveExibirDuasMensagensDeErro() {

		usuarios.visita();

		usuarios.novo().cadastra("", "");

		assertTrue(usuarios.usuarioObrigatorio());
		assertTrue(usuarios.emailObrigatorio());
	}

	@Test
	public void deveIrParaATelaDeNovoUsuario() {

		usuarios.visita();

		assertTrue(usuarios.novo().existeNaPagina("Nome:"));

	}

	@Test
	public void deveExcluirUmUsuario() {
		usuarios.visita();
		
		usuarios.novo().cadastra("Jose Saraiva", "jd.saraiva@gmail.com");
		
        assertTrue(usuarios.existeNaListagem("Jose Saraiva", "jd.saraiva@gmail.com"));

        usuarios.deletaUsuarioNaPosicao(1);

        assertFalse(usuarios.existeNaListagem("Jose Saraiva", "jd.saraiva@gmail.com"));	
    }
	
	@Test
	public void deveAlterarUmUsuario() {
		usuarios.visita();

		usuarios.novo().cadastra("Paulo Henrique", "paulo@henrique.com");
		
        usuarios.alteraUsuarioNaPosicao(1).edita("Paulo Henrique Ganso", "ph@ganso.com");

        assertTrue(usuarios.existeNaListagem("Paulo Henrique Ganso", "ph@ganso.com"));	
    }
	
	

	@After
	public void encerra() {
		driver.close();
	}
}
