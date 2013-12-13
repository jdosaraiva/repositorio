package br.com.caelum.investimento;

import java.util.Random;

public class Arrojado implements Investimento {

	@Override
	public double calculaRendimento(ContaBancaria conta) {
		Random r = new Random();

		double chances = r.nextDouble();
		if (chances <= 0.2) {
			return conta.getSaldo() * 0.05 * 0.75;
		} else if (chances > 0.2 && chances <= 0.5) {
			return conta.getSaldo() * 0.03 * 0.75;
		} else {
			return conta.getSaldo() * 0.06 * 0.75;
		}
	}

}
