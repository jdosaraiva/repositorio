package br.com.caelum.orcamento;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import br.com.caelum.desconto.OrcamentoBuilder;

public class IHITTest {

	@Test
	public void deveCalcularComTaxacaoParaDoisItensDeMesmoNome() {
		
		Orcamento orcamento = new OrcamentoBuilder(1000.0)
			.comItem("TABLET", 500.0)
			.comItem("TABLET", 500.0)
			.constroi();
		
		Imposto ihit = new IHIT();
		
		assertThat(230.0, equalTo(ihit.calcula(orcamento)));
	}

	@Test
	public void deveCalcularComTaxacaoParaItensNaoRepetidos() {
		
		Orcamento orcamento = new OrcamentoBuilder(1000.0)
			.comItem("TABLET", 500.0)
			.comItem("SMART PHONE", 500.0)
			.constroi();
		
		Imposto ihit = new IHIT();
		
		assertThat(20.0, equalTo(ihit.calcula(orcamento)));
	}
}
