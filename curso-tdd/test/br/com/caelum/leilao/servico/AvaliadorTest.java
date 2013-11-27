package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.caelum.leilao.servico.Avaliador;
import br.com.caelum.leilao.servico.Lance;
import br.com.caelum.leilao.servico.Leilao;
import br.com.caelum.leilao.servico.Usuario;


public class AvaliadorTest {

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(maria,250.0));
        leilao.propoe(new Lance(joao,300.0));
        leilao.propoe(new Lance(jose,400.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        // comparando a saida com o esperado
        double maiorEsperado = 400;
        double menorEsperado = 250;
        
        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);     
    }
	
	@Test
	public void deveEntenderLancesEmOrdemDecrescente() {
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(jose,400.0));
        leilao.propoe(new Lance(joao,300.0));
        leilao.propoe(new Lance(maria,200.0));
        leilao.propoe(new Lance(joao,100.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        // comparando a saida com o esperado
        double maiorEsperado = 400;
        double menorEsperado = 100;
        
        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);     
    }

	@Test
    public void deveEntenderLeilaoComApenasUmLance() {
        Usuario joao = new Usuario("Joao"); 
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao,1000.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        assertEquals(1000, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(1000, leiloeiro.getMenorLance(), 0.0001);
    }

	@Test
    public void deveEntenderLeilaoComLancesAleatorios() {
		// 200, 450, 120, 700, 630, 230
		Usuario user = new Usuario("Usuario");
		
		Leilao leilao = new Leilao("Sabre de Luz do mestre Yoda");
		
		leilao.propoe(new Lance(user, 200));
		leilao.propoe(new Lance(user, 450));
		leilao.propoe(new Lance(user, 120));
		leilao.propoe(new Lance(user, 700));
		leilao.propoe(new Lance(user, 630));
		leilao.propoe(new Lance(user, 230));
		
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        assertEquals(120, leiloeiro.getMenorLance(), 0.0001);
        assertEquals(700, leiloeiro.getMaiorLance(), 0.0001);
	}	
	
	@Test
    public void deveEncontrarOsTresMaioresLances() {
        Usuario joao = new Usuario("João");
        Usuario maria = new Usuario("Maria");
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(maria, 200.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(maria, 400.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(3, maiores.size());
        assertEquals(400, maiores.get(0).getValor(), 0.00001);
        assertEquals(300, maiores.get(1).getValor(), 0.00001);
        assertEquals(200, maiores.get(2).getValor(), 0.00001);    }
	
	@Test
	public void pegaAmediaDosLances() {
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(maria,250.0));
        leilao.propoe(new Lance(joao,300.0));
        leilao.propoe(new Lance(jose,400.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        
        double mediaDosLances = 316.666667;

        assertEquals(mediaDosLances, leiloeiro.getLanceMedio(), 0.0001);
	}
	
	@Test
	public void umLeilaoCom5LancesDeveDevolverOsTresMaiores () {
		Usuario user = new Usuario("Usuario");
		
		Leilao leilao = new Leilao("Sabre de Luz do mestre Yoda");
		
		leilao.propoe(new Lance(user, 450));
		leilao.propoe(new Lance(user, 120));
		leilao.propoe(new Lance(user, 700));
		leilao.propoe(new Lance(user, 630));
		leilao.propoe(new Lance(user, 230));
		
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        
        assertEquals(3, maiores.size());
        assertEquals(700, maiores.get(0).getValor(), 0.0001);
        assertEquals(630, maiores.get(1).getValor(), 0.0001);
        assertEquals(450, maiores.get(2).getValor(), 0.0001);
	}

	@Test
	public void umLeilaoCom2LancesDeveDevolverOsLancesQueEncontrou () {
		Usuario user = new Usuario("Usuario");
		
		Leilao leilao = new Leilao("Sabre de Luz do mestre Yoda");
		
		leilao.propoe(new Lance(user, 450));
		leilao.propoe(new Lance(user, 120));
		
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        
        assertEquals(2, maiores.size());
        assertEquals(450, maiores.get(0).getValor(), 0.0001);
        assertEquals(120, maiores.get(1).getValor(), 0.0001);
	}

	@Test
	public void umLeilaoSemLancesDeveDevolverListaVazia() {
		Usuario user = new Usuario("Usuario");
		
		Leilao leilao = new Leilao("Boneca Inflável");
		
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        
        assertEquals(0, maiores.size());
	}
}
