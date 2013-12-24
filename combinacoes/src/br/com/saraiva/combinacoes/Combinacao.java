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
		
		int d = (n - p) > p ? (n - p) : p;
		
		return fat(n, d) / fat(n - d);
	}

	public static double fat(int m, int n) {

		if (n > m) {
			throw new IllegalArgumentException(
					"O primeiro argumento deve ser maior ou igual ao segundo!");
		}

		if (n == m) {
			return 1;
		}

		return m * fat(m - 1, n);

	}

}
