package br.com.caelum.orcamento;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.caelum.desconto.OrcamentoBuilder;

public class TemplateDeImpostoCondicionalTest {

	@Test
	public void test() {
		
		Orcamento orcamentoMenor = new OrcamentoBuilder(200)
				.comItem("LAPIS", 50.0)
				.comItem("LAPIS", 50.0)
				.comItem("LAPIS", 50.0)
				.comItem("LAPIS", 50.0)
				.constroi();
		
		Orcamento orcamentoMaior = new OrcamentoBuilder(600)
				.comItem("LAPIS",  100.0)
				.comItem("LAPIS",  100.0)
				.comItem("CANETA", 200.0)
				.comItem("CANETA", 200.0)
				.constroi();

		Imposto icpp = new ICPP();

		Imposto ikcv = new IKCV();
		
		assertThat(200 * 0.05, equalTo(icpp.calcula(orcamentoMenor)));
		assertThat(600 * 0.07, equalTo(icpp.calcula(orcamentoMaior)));

		assertThat(200 * 0.06, equalTo(ikcv.calcula(orcamentoMenor)));
		assertThat(600 * 0.10, equalTo(ikcv.calcula(orcamentoMaior)));
	}

}
