package br.com.caelum.desconto;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.orcamento.Orcamento;

public class CalculadorDeDescontosTest {
	
	private Orcamento orcamento;
	
	@Before
	public void setUp() {
	}

	@Test
	public void deveCalcularUmDescontoPor5ItensSimples() {
		orcamento = new OrcamentoBuilder(1000)
				.comItem("LAPIS",  100.0)
				.comItem("LAPIS",  100.0)
				.comItem("CANETA", 200.0)
				.comItem("CANETA", 200.0)
				.comItem("CANETA", 200.0)
				.comItem("CANETA", 200.0)
				.constroi();
		
		Desconto d1 = new DescontoPorCincoItens();

		assertThat(100.0, equalTo(d1.desconta(orcamento)));
	}

	@Test
	public void deveCalcularUmDescontoPorMaisDeQuinhentosReais() {
		orcamento = new OrcamentoBuilder(1000)
				.comItem("TABLET NEXUS 7", 1000.0)
				.constroi();
		
		Desconto d1 = new DescontoPorCincoItens();
		Desconto d2 = new DescontoPorMaisDeQuinhentosReais();
		Desconto d3 = new SemDesconto();
		
		d1.setProximo(d2);
		d2.setProximo(d3);
		
		assertThat(70.0, equalTo(d1.desconta(orcamento)));
	}
	

	@Test
	public void deveCalcularUmDescontoPorVendaCasada() {
		orcamento = new OrcamentoBuilder(200)
				.comItem("CANETA", 150.0)
				.comItem("LAPIS", 50.0)
				.constroi();
		
		Desconto d1 = new DescontoPorCincoItens();
		Desconto d2 = new DescontoPorMaisDeQuinhentosReais();
		Desconto d3 = new DescontoPorVendaCasada();
		Desconto d4 = new SemDesconto();
		
		d1.setProximo(d2);
		d2.setProximo(d3);
		d3.setProximo(d4);
		
		assertThat(10.0, equalTo(d1.desconta(orcamento)));
	}
	
}
