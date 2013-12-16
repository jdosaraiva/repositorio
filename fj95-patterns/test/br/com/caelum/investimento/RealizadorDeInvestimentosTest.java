package br.com.caelum.investimento;

import static org.hamcrest.MatcherAssert.assertThat;
<<<<<<< HEAD
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
=======
import static org.hamcrest.Matchers.*;
>>>>>>> 0403a2765fc329c97029380be600996a12b813e0

import org.junit.Before;
import org.junit.Test;

public class RealizadorDeInvestimentosTest {

    ContaBancaria conta = new ContaBancaria(10000.0);
	
	@Before
	public void setUp() {
        conta = new ContaBancaria(10000.0);
	}

	@Test
	public void testeDoInvestimentoConservador() {

        Investimento conservador = new Conservador();

        RealizadorDeInvestimentos realizador = new RealizadorDeInvestimentos();
        
        realizador.realizaInvestimento(conta, conservador);
		assertThat(conta.getSaldo(), equalTo(10600.0));
<<<<<<< HEAD
	}

	@Test
	public void testeDoInvestimentoModerado() {

        Investimento moderado = new Moderado();

        RealizadorDeInvestimentos realizador = new RealizadorDeInvestimentos();
        
        double menor = 	10000 * (1 + 0.025 * 0.75);
        double maior = 	10000 * (1 + 0.070 * 0.75);

		realizador.realizaInvestimento(conta, moderado);
		assertThat(conta.getSaldo(), anyOf(equalTo(menor), equalTo(maior)));
		
	}

	@Test
	public void testeDoInvestimentoArrojado() {

        Investimento arrojado = new Arrojado();

        RealizadorDeInvestimentos realizador = new RealizadorDeInvestimentos();

        double menor = 	10000 * (1 + 0.03 * 0.75);
        double medio = 	10000 * (1 + 0.05 * 0.75);
        double maior = 	10000 * (1 + 0.06 * 0.75);
=======
		
		conta.setSaldo(10000.0);
		
		double min = 10000.0 * (1 + (0.025 * 0.75));
		double max = 10000.0 * (1 + (0.070 * 0.75));
		
		realizador.realizaInvestimento(conta, moderado);
		assertThat(conta.getSaldo(), anyOf(equalTo(min), equalTo(max)));

		conta.setSaldo(10000.0);
>>>>>>> 0403a2765fc329c97029380be600996a12b813e0

		double avg = 10000.0 * (1 + (0.03 * 0.75));
		min = 10000.0 * (1 + (0.05 * 0.75));
		max = 10000.0 * (1 + (0.06 * 0.75));
		
		realizador.realizaInvestimento(conta, arrojado);
<<<<<<< HEAD
		assertThat(conta.getSaldo(), anyOf(equalTo(menor), equalTo(medio), equalTo(maior)));
=======
		assertThat(conta.getSaldo(), anyOf(equalTo(min), equalTo(avg), equalTo(max)));
>>>>>>> 0403a2765fc329c97029380be600996a12b813e0
		
	}

}
