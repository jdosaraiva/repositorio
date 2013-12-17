package br.com.caelum.orcamento;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class ISSComICMSTest {

	@Test
	public void deveCalcularOISSCompostoComICMS() {

		Orcamento orcamento = new Orcamento(100);

		Imposto issComIcms = new ISS(new ICMS());

		double valorImposto = issComIcms.calcula(orcamento);

		assertThat(16.0, equalTo(valorImposto));

	}

}
