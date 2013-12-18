package br.com.caelum.conta;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class EstadoDeUmaContaTest {

	@Test
	public void testaOEstadoDeUmaConta() {
		
		Conta conta = new Conta("Teste", 1000.0);
		
		assertThat(conta.estado, instanceOf(POSITIVO.class));
		
		conta = new Conta("Teste", -1000.0);

		assertThat(conta.estado, instanceOf(NEGATIVO.class));
	}

	
	@Test
	public void deveEfetuarUmSaqueMenorQueOSaldo() {

		Conta conta = new Conta("Teste", 1000.0);
		
		conta.efetuarSaque(100.0);
		
		assertThat(conta.getSaldo(), equalTo(900.0));
		assertThat(conta.estado, instanceOf(POSITIVO.class));

	}

	@Test
	public void deveEfetuarUmSaqueQueDeixaAContaNegativa() {

		Conta conta = new Conta("Teste", 90.0);
		
		conta.efetuarSaque(100.0);
		
		assertThat(conta.getSaldo(), equalTo(-10.0));
		assertThat(conta.estado, instanceOf(NEGATIVO.class));

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveConseguirEfetuarUmSaqueDeUmaContaNegativa() {
		
		Conta conta = new Conta("Teste", -10.0);
		
		assertThat(conta.estado, instanceOf(NEGATIVO.class));
		
		conta.efetuarSaque(100.0);
	}
	
	@Test
	public void deveFazerUmDepositoNumaContaPositiva() {
		Conta conta = new Conta("Teste", 100.0);
		
		assertThat(conta.estado, instanceOf(POSITIVO.class));
		
		conta.eftuarDeposito(100.0);
		
		assertThat(conta.getSaldo(), equalTo(198.0));
	}

	@Test
	public void deveFazerUmDepositosNumaContaNegativaAteElaFicarPositiva() {
		Conta conta = new Conta("Teste", -100.0);
		
		assertThat(conta.estado, instanceOf(NEGATIVO.class));
		
		conta.eftuarDeposito(100.0);
		
		assertThat(conta.getSaldo(), equalTo(-5.0));
		assertThat(conta.estado, instanceOf(NEGATIVO.class));
		
		conta.eftuarDeposito(100.0);
		assertThat(conta.getSaldo(), equalTo(90.0));
		assertThat(conta.estado, instanceOf(POSITIVO.class));
		
	}
}
