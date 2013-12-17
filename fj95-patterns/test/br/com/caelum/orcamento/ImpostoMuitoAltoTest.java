package br.com.caelum.orcamento;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class ImpostoMuitoAltoTest {

	@Test
	public void deveCalcularOImpotoMuitoAltoComOutroImposto() {
		
		Orcamento orcamento = new Orcamento(100.0);
		
		Imposto imposto = new ImpostoMuitoAlto(new ISS());
		
		double valorDoImposto = imposto.calcula(orcamento);
		
		assertThat(26.0, equalTo(valorDoImposto));
		
	}

}
