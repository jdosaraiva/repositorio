package br.com.saraiva.combinacoes;

import static br.com.saraiva.combinacoes.Combinacao.*;

public class CalculaCombinacao {

	public static void main(String[] args) {
		
		if (args.length < 2) {
			System.out.println("Uso: combinacao <n> <p>");
			System.exit(0);
		}
		
		int n = Integer.parseInt(args[0]);
		int p = Integer.parseInt(args[1]);
		
		System.out.println("Combinacao(n=[" + n + "], p=[" + p + "]):[" + combinacao(n, p) + "]");
		
		System.exit(1);

	}

}
