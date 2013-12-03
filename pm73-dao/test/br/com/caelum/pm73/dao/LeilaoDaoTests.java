package br.com.caelum.pm73.dao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.pm73.dominio.Leilao;
import br.com.caelum.pm73.dominio.Usuario;

public class LeilaoDaoTests {
	private Session session;
	private LeilaoDao leilaoDao;
	private UsuarioDao usuarioDao;

	@Before
	public void antes() {
		session = new CriadorDeSessao().getSession();
		leilaoDao = new LeilaoDao(session);
		usuarioDao = new UsuarioDao(session);

		// inicia transacao
		session.beginTransaction();
	}

	@After
	public void depois() {
		// faz o rollback
		session.getTransaction().rollback();
		session.close();
	}

	@Test
	public void deveContarLeiloesNaoEncerrados() {
		// criamos um usuario
		Usuario mauricio = new Usuario("Mauricio Aniche",
				"mauricio@aniche.com.br");

		// criamos os dois leiloes
		Leilao ativo = new Leilao("Geladeira", 1500.0, mauricio, false);
		Leilao encerrado = new Leilao("XBox", 700.0, mauricio, false);
		encerrado.encerra();

		// persistimos todos no banco
		usuarioDao.salvar(mauricio);
		leilaoDao.salvar(ativo);
		leilaoDao.salvar(encerrado);

		// invocamos a acao que queremos testar
		// pedimos o total para o DAO
		long total = leilaoDao.total();

		assertEquals(1L, total);
	}

	@Test
	public void deveRetornarZeroCasoNaoHajaLeiloesNaoEncerrados() {
		// criamos um usuario
		Usuario mauricio = new Usuario("Mauricio Aniche",
				"mauricio@aniche.com.br");

		// criamos os dois leiloes
		Leilao encerrado1 = new Leilao("Geladeira", 1500.0, mauricio, false);
		Leilao encerrado2 = new Leilao("XBox", 700.0, mauricio, false);

		encerrado1.encerra();
		encerrado2.encerra();

		// persistimos todos no banco
		usuarioDao.salvar(mauricio);
		leilaoDao.salvar(encerrado1);
		leilaoDao.salvar(encerrado2);

		// invocamos a acao que queremos testar
		// pedimos o total para o DAO
		long total = leilaoDao.total();

		assertEquals(0L, total);
	}
	
	@Test
	public void deveRetornarApenasOLeilaoNaoUsado() {
		// criamos um usuario
		Usuario mauricio = new Usuario("Mauricio Aniche",
				"mauricio@aniche.com.br");

		// criamos os dois leiloes
		Leilao usado = new Leilao("Geladeira", 1500.0, mauricio, true);
		Leilao naoUsado = new Leilao("XBox", 700.0, mauricio, false);

		// persistimos todos no banco
		usuarioDao.salvar(mauricio);
		leilaoDao.salvar(usado);
		leilaoDao.salvar(naoUsado);
		
		List<Leilao> novos = leilaoDao.novos();
		
		assertEquals(1, novos.size());
		assertEquals("XBox", novos.get(0).getNome());

	}

	@Test
	public void deveRetornarApenasLeiloesAntigos() {
		// criamos um usuario
		Usuario mauricio = new Usuario("Mauricio Aniche",
				"mauricio@aniche.com.br");

		// criamos os dois leiloes
		Leilao novo1 = new Leilao("Geladeira", 1500.0, mauricio, true);
		Leilao novo2 = new Leilao("XBox", 700.0, mauricio, false);
		Leilao antigo1 = new Leilao("TV de Plasma 50''", 300.0, mauricio, false);
		Leilao antigo2 = new Leilao("Home Theater", 1700.0, mauricio, false);
		
		Calendar hoje = Calendar.getInstance();
		
		novo1.setDataAbertura(hoje);
		novo2.setDataAbertura(hoje);
		
		Calendar antigo = Calendar.getInstance();
		antigo.add(Calendar.DAY_OF_MONTH, -8);
		
		antigo1.setDataAbertura(antigo);
		antigo2.setDataAbertura(antigo);
		
		// persistimos todos no banco
		usuarioDao.salvar(mauricio);
		leilaoDao.salvar(novo1);
		leilaoDao.salvar(novo2);
		leilaoDao.salvar(antigo1);
		leilaoDao.salvar(antigo2);
		
		List<Leilao> antigos = leilaoDao.antigos();
		
		assertEquals(2, antigos.size());
		assertEquals("TV de Plasma 50''", antigos.get(0).getNome());
		assertEquals("Home Theater", antigos.get(1).getNome());

	}

	@Test
	public void deveRetornarUmLeilaoCriadoHaSeteDias() {
		// criamos um usuario
		Usuario mauricio = new Usuario("Mauricio Aniche",
				"mauricio@aniche.com.br");

		// criamos os dois leiloes
		Leilao novo = new Leilao("Geladeira", 1500.0, mauricio, true);
		Leilao antigo = new Leilao("XBox", 700.0, mauricio, false);
		
		Calendar hoje = Calendar.getInstance();
		novo.setDataAbertura(hoje);
		
		Calendar seteDias = Calendar.getInstance();
		seteDias.add(Calendar.DAY_OF_MONTH, -7);
		
		antigo.setDataAbertura(seteDias);
		
		// persistimos todos no banco
		usuarioDao.salvar(mauricio);
		leilaoDao.salvar(novo);
		leilaoDao.salvar(antigo);
		
		List<Leilao> velhos = leilaoDao.antigos();
		
		assertEquals(1, velhos.size());
		assertEquals("XBox", velhos.get(0).getNome());

	}
}
