package br.com.caelum.orcamento;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class DescontoExtraTest {

	/**
	 * 
	 */
	@Test
	public void test() {

		Orcamento reforma = new Orcamento(500.0);

		reforma.aplicaDescontoExtra();

		assertThat(475.0, equalTo(reforma.getValor()));

		reforma.aprova(); // aprova nota!

		assertThat(reforma.estadoAtual, instanceOf(Aprovado.class));

		reforma.aplicaDescontoExtra();

		assertThat(465.5, equalTo(reforma.getValor()));

		reforma.finaliza();

		assertThat(reforma.estadoAtual, instanceOf(Finalizado.class));

		// reforma.aplicaDescontoExtra(); lancaria excecao, pois não pode dar
		// desconto nesse estado
		// reforma.aprova(); lança exceção, pois não pode ir para aprovado

	}

}
