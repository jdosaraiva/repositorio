package br.com.caelum.conta;

public class NEGATIVO implements EstadoDeUmaConta {

	@Override
	public void efetuarSaque(Conta conta, double valorSaque) {
		throw new IllegalArgumentException("A conta está negativa, então não é possível efetuar um saque");
	}

	@Override
	public void efetuarDeposito(Conta conta, double valorDeposito) {
		double saldo = conta.getSaldo();
		saldo += valorDeposito * 0.95;
		conta.setSaldo(saldo);

		if (saldo > 0) {
			conta.estado = new POSITIVO();
		}
	}

}
