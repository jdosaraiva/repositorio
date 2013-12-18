package br.com.caelum.conta;

public interface EstadoDeUmaConta {

	void efetuarSaque(Conta conta, double valorSaque);

	void efetuarDeposito(Conta conta, double valorDeposito);
	
}
