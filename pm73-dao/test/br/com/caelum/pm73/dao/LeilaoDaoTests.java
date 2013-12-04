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
		Usuario mauricio = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

		// criamos os dois leiloes
		Leilao ativo = new LeilaoBuilder()
				.comNome("Geladeira")
				.comValor(1500.0)
				.comDono(mauricio)
				.constroi();
		
		Leilao encerrado = new LeilaoBuilder()
				.comNome("XBox")
				.comValor(700.0)
				.comDono(mauricio)
				.encerrado()
				.constroi();

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
		Usuario mauricio = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

		// criamos os dois leiloes
		Leilao encerrado1 = new LeilaoBuilder()
				.comNome("Geladeira")
				.comValor(1500.0)
				.comDono(mauricio)
				.encerrado()
				.constroi();
		Leilao encerrado2 = new LeilaoBuilder()
				.comNome("XBox")
				.comValor(700.0)
				.comDono(mauricio)
				.encerrado()
				.constroi();

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
		Usuario mauricio = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

		// criamos os dois leiloes
		Leilao usado = new LeilaoBuilder()
					.comNome("Geladeira")
					.comValor(1500.0)
					.comDono(mauricio)
					.usado()
					.constroi();
		Leilao naoUsado = new LeilaoBuilder()
				.comNome("XBox")
				.comValor(700.0)
				.comDono(mauricio)
				.constroi();
		
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
		Usuario mauricio = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

		// criamos os dois leiloes
		Leilao novo1 = new LeilaoBuilder()
				.comNome("Geladeira")
				.comValor(1500.0)
				.comDono(mauricio)
				.usado()
				.constroi();
		Leilao novo2 = new LeilaoBuilder()
				.comNome("XBox")
				.comValor(700.0)
				.comDono(mauricio)
				.constroi();
		Leilao antigo1 = new LeilaoBuilder()
				.comNome("TV de Plasma 50''")
				.comValor(3000.0)
				.comDono(mauricio)
				.diasAtras(8)
				.constroi();
		Leilao antigo2 = new LeilaoBuilder()
				.comNome("Home Theater")
				.comValor(1700.0)
				.comDono(mauricio)
				.diasAtras(8)
				.constroi();
		
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
		Usuario mauricio = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

		// criamos os dois leiloes
		Leilao novo = new LeilaoBuilder()
				.comNome("Geladeira")
				.comValor(1500.0)
				.comDono(mauricio)
				.usado()
				.constroi();
		Leilao antigo = new LeilaoBuilder()
				.comNome("XBox")
				.comValor(700.0)
				.comDono(mauricio)
				.diasAtras(7)
				.constroi();
		
		// persistimos todos no banco
		usuarioDao.salvar(mauricio);
		leilaoDao.salvar(novo);
		leilaoDao.salvar(antigo);
		
		List<Leilao> velhos = leilaoDao.antigos();
		
		assertEquals(1, velhos.size());
		assertEquals("XBox", velhos.get(0).getNome());

	}
	
	@Test
    public void deveTrazerLeiloesNaoEncerradosNoPeriodo() {

        // criando as datas
        Calendar comecoDoIntervalo = Calendar.getInstance();
        comecoDoIntervalo.add(Calendar.DAY_OF_MONTH, -10);
        Calendar fimDoIntervalo = Calendar.getInstance();

        Usuario mauricio = new Usuario("Mauricio Aniche",
                "mauricio@aniche.com.br");

        // criando os leiloes, cada um com uma data
        Leilao leilao1 = new LeilaoBuilder()
        		.comNome("XBox")
        		.comValor(700.0)
        		.comDono(mauricio)
        		.diasAtras(2)
        		.constroi();

        Leilao leilao2 = new LeilaoBuilder()
        		.comNome("Geladeira")
        		.comValor(1700.0)
        		.comDono(mauricio)
        		.diasAtras(20)
        		.constroi();

        // persistindo os objetos no banco
        usuarioDao.salvar(mauricio);
        leilaoDao.salvar(leilao1);
        leilaoDao.salvar(leilao2);

        // invocando o metodo para testar
        List<Leilao> leiloes = 
                leilaoDao.porPeriodo(comecoDoIntervalo, fimDoIntervalo);

        // garantindo que a query funcionou
        assertEquals(1, leiloes.size());
        assertEquals("XBox", leiloes.get(0).getNome());
    }
	
	@Test
    public void naoDeveTrazerLeiloesEncerradosNoPeriodo() {

        // criando as datas
        Calendar comecoDoIntervalo = Calendar.getInstance();
        comecoDoIntervalo.add(Calendar.DAY_OF_MONTH, -10);
        Calendar fimDoIntervalo = Calendar.getInstance();

        Usuario mauricio = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

        // criando os leiloes, cada um com uma data
        Leilao leilao1 = new LeilaoBuilder()
				.comNome("Geladeira")
				.comValor(1700.0)
				.comDono(mauricio)
				.encerrado()
				.diasAtras(2)
				.constroi();
        

        // persistindo os objetos no banco
        usuarioDao.salvar(mauricio);
        leilaoDao.salvar(leilao1);

        // invocando o metodo para testar
        List<Leilao> leiloes = 
                leilaoDao.porPeriodo(comecoDoIntervalo, fimDoIntervalo);

        // garantindo que a query funcionou
        assertEquals(0, leiloes.size());
    }	
}
