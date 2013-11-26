package br.com.caelum.leilao.servico;
import org.junit.Assert;
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
        
        Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
        Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);     
    }
	
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

        Assert.assertEquals(mediaDosLances, leiloeiro.getLanceMedio(), 0.0001);
	}
}
