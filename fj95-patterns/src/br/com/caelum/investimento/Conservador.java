package br.com.caelum.investimento;

public class Conservador implements Investimento {

	@Override
	public double calculaRendimento(ContaBancaria conta) {
		return conta.getSaldo() * 0.08 * 0.75;
	}

}
