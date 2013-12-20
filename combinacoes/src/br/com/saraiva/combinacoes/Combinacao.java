package br.com.saraiva.combinacoes;

public class Combinacao {

	public static double fat(int n) {

		if (n == 0) {
			return 1;
		}

		return n * fat(n - 1);
	}

	public static double combinacao(int n, int p) {

		if (n < p) {
			throw new IllegalArgumentException("N deve ser maior ou igual a p");
		}

		double result = fat(n) / (fat(p) * fat(n - p));

		return result;

	}

}
