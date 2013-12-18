package br.com.caelum.conta;

public class POSITIVO implements EstadoDeUmaConta {

	public void efetuarSaque(Conta conta, double valorSaque) {
		double saldo = conta.getSaldo();
		saldo -= valorSaque;
		conta.setSaldo(saldo);
		if (saldo < 0) {
			conta.estado = new NEGATIVO();
		}
	}
	
	public void efetuarDeposito(Conta conta, double valorDeposito) {
		double saldo = conta.getSaldo();
		saldo += valorDeposito * 0.98;
		conta.setSaldo(saldo);
	}
	
}
