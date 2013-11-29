package br.com.caelum.leilao.servico;

import static br.com.caelum.leilao.servico.LeilaoTemUmLance.temUmLance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AvaliadorTest {

	private Avaliador leiloeiro;
	private Usuario joao;
	private Usuario jose;
	private Usuario maria;

	@Before
	public void setUp() {
		this.leiloeiro = new Avaliador();
		this.joao = new Usuario("João");
		this.jose = new Usuario("José");
		this.maria = new Usuario("Maria");
	}

	@After
	public void finaliza() {
	}

	@BeforeClass
	public static void testandoBeforeClass() {
		System.out.println("before class");
	}

	@AfterClass
	public static void testandoAfterClass() {
		System.out.println("after class");
	}

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
				.lance(maria, 250.0)
				.lance(joao, 300.0)
				.lance(jose, 400.0)
				.constroi();

		leiloeiro.avalia(leilao);

		assertThat(leiloeiro.getMenorLance(), equalTo(250.0));
	    assertThat(leiloeiro.getMaiorLance(), equalTo(400.0));
	}

	@Test
	public void deveEntenderLancesEmOrdemDecrescente() {

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
				.lance(jose,  400.0)
				.lance(joao,  300.0)
				.lance(maria, 200.0)
				.lance(joao,  100.0)
				.constroi();

		leiloeiro.avalia(leilao);

		assertThat(leiloeiro.getMenorLance(), equalTo(100.0));
	    assertThat(leiloeiro.getMaiorLance(), equalTo(400.0));
	}

	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		Leilao leilao = new CriadorDeLeilao()
				.para("Playstation 3 Novo")
				.lance(joao, 1000.0)
				.constroi();

		leiloeiro.avalia(leilao);

		assertThat(leiloeiro.getMenorLance(), equalTo(1000.0));
	    assertThat(leiloeiro.getMaiorLance(), equalTo(1000.0));
	}

	@Test
	public void deveEntenderLeilaoComLancesAleatorios() {

		Leilao leilao = new CriadorDeLeilao()
				.para("Sabre de Luz do mestre Yoda")
				.lance(joao,  200.0)
				.lance(maria, 450.0)
				.lance(jose,  120.0)
				.lance(joao,  700.0)
				.lance(maria, 630.0)
				.lance(jose,  230.0)
				.constroi();

		leiloeiro.avalia(leilao);

		assertThat(leiloeiro.getMenorLance(), equalTo(120.0));
	    assertThat(leiloeiro.getMaiorLance(), equalTo(700.0));
	}

	@Test
	public void deveEncontrarOsTresMaioresLances() {
		Leilao leilao = new CriadorDeLeilao()
		        .para("Playstation 3 Novo")
				.lance(joao,  100.0)
				.lance(maria, 200.0)
				.lance(joao,  300.0)
				.lance(maria, 400.0)
				.constroi();

		leiloeiro.avalia(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();

		assertEquals(3, maiores.size());
		assertThat(maiores, hasItems(
                new Lance(maria, 400), 
                new Lance(joao,  300),
                new Lance(maria, 200)
        ));
	}

	@Test
	public void pegaAmediaDosLances() {

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
				.lance(maria, 200.0)
				.lance(joao,  300.0)
				.lance(jose,  400.0)
				.constroi();

		leiloeiro.avalia(leilao);

		assertThat(leiloeiro.getLanceMedio(), equalTo(300.0));
	}

	@Test
	public void umLeilaoCom5LancesDeveDevolverOsTresMaiores() {
		Leilao leilao = new CriadorDeLeilao()
				.para("Sabre de Luz do mestre Yoda")
				.lance(joao,  450.0)
				.lance(maria, 120.0)
				.lance(joao,  700.0)
				.lance(maria, 630.0)
				.lance(joao,  230.0)
				.constroi();

		leiloeiro.avalia(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();

		assertEquals(3, maiores.size());
		assertThat(maiores, hasItems(
                new Lance(joao,  700), 
                new Lance(maria, 630),
                new Lance(joao,  450)
        ));
	}

	@Test
	public void umLeilaoCom2LancesDeveDevolverOsLancesQueEncontrou() {
		Leilao leilao = new CriadorDeLeilao()
				.para("Sabre de Luz do mestre Yoda")
				.lance(joao,  450.0)
				.lance(maria, 120.0)
				.constroi();

		leiloeiro.avalia(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();

		assertEquals(2, maiores.size());
		assertThat(maiores, hasItems(
                new Lance(joao,  450), 
                new Lance(maria, 120)
        ));
	}

	@Test(expected = RuntimeException.class)
	public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {
		Leilao leilao = new CriadorDeLeilao()
				.para("Playstation 3 Novo")
				.constroi();

		leiloeiro.avalia(leilao);
	}
	
	@Test
	public void verificaSeUmDeterminadoLanceEstaNoLeilao() {
		Leilao leilao = new CriadorDeLeilao()
			.para("Playstation 3 Novo")
			.lance(joao,  2000.0)
			.lance(maria, 1000.0)
			.lance(jose,   500.0)
			.lance(joao,  2100.0)
			.constroi();
		
		assertThat(leilao, temUmLance(new Lance(jose, 500.0)));
	}
	
}
