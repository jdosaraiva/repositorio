package br.com.saraiva.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.saraiva.combinacoes.Combinacao;

public class GeradorDeCombinacoes {

	public static void main(String[] args) {

		if (args.length < 5) {
			System.out.println("Voce deve passar o numero de dezenas em cada combinacao e");
			System.out.println("no minimos 4 dezenas a combinar.");
			System.exit(1);
		}
		
		int profundidade = Integer.parseInt(args[0]);
		
		if (profundidade >= args.length-1) {
			System.out.println("O numero de dezenas em cada combinacao tem que ser menor");
			System.out.println("que o numero de dezenas a combinar.");
			System.exit(1);
		}
		
		if (profundidade < 3 ) {
			System.out.println("O menor numero de dezenas por combinacao e tres.");
			System.exit(1);
		}

		if (profundidade > 15 ) {
			System.out.println("O maior numero de dezenas por combinacao e 15.");
			System.exit(1);
		}

		Integer[] dezenasEscolhidas = new Integer[args.length - 1];
		
		for (int i = 1; i < args.length; i++) {
			dezenasEscolhidas[i-1] = Integer.valueOf(args[i]);
		}

		Chronometer.start();

		listaCombinacoes(dezenasEscolhidas, profundidade);

		Chronometer.stop();
		
		if (Chronometer.stime() <= 60) { 
			System.out.printf("Tempo de Processamento:[%,.2f]s\n",
					Chronometer.stime());
		} else {
			System.out.printf("Tempo de Processamento:[%,.2f]m\n",
					Chronometer.mtime());
		}

		System.exit(0);
	}

	private static void listaCombinacoes(Integer[] dezenasEscolhidas,
			int profundidade) {
		List<Integer[]> listaInicial = new ArrayList<Integer[]>();

		for (int i = 0; i < dezenasEscolhidas.length; i++) {
			for (int j = i + 1; j < dezenasEscolhidas.length; j++) {
				Integer[] x = { dezenasEscolhidas[i], dezenasEscolhidas[j] };
				listaInicial.add(x);
			}
		}

		System.out.println("Combinacao(n:[" + dezenasEscolhidas.length
				+ "], p:[" + profundidade + "]):["
				+ Combinacao.combinacao(dezenasEscolhidas.length, profundidade)
				+ "]");

		List<Integer[]> listaSemRepetidos = null;

		for (int i = 0; i < profundidade - 2; i++) {

			List<Integer[]> m = geraListaDeCombinacoes(dezenasEscolhidas,
					listaInicial);

			listaSemRepetidos = m;

			listaInicial = listaSemRepetidos;

		}
		
		System.out.println(); 
		

		for (Integer[] integers : listaSemRepetidos) {
			for (int i = 0; i < integers.length; i++) {
				System.out.printf("%02d ", integers[i]);
			}
			System.out.println();
		}
	}

	private static boolean achou(List<Integer[]> lista, Integer[] item,
			int posicao) {

		String procurada = "";
		for (int i = 0; i < item.length; i++) {
			procurada = procurada.concat(String.valueOf(item[i])).concat("-");
		}

		String aux = null;

		int posAtual = 0;

		for (Integer[] inteiros : lista) {

			if (posAtual > posicao) {
				posAtual++;
				continue;
			}

			aux = new String();
			for (int i = 0; i < inteiros.length; i++) {
				aux = aux.concat(String.valueOf(inteiros[i])).concat("-");
			}

			if (procurada.equals(aux))
				return true;

		}

		return false;
	}

	@SuppressWarnings("unused")
	private static boolean contemRepeticoes(Integer[] meuarray) {

		for (int i = 0; i < meuarray.length - 1; i++) {
			for (int j = i + 1; j < meuarray.length; j++) {
				if (meuarray[i] == meuarray[j]) {
					return true;
				}
			}
		}

		return false;

	}

	@SuppressWarnings("unused")
	private static List<Integer[]> eliminaRepeticoes(
			List<Integer[]> listaOriginal) {

		List<Integer[]> semRepeticoes = new ArrayList<Integer[]>();

		for (int i = 0; i < listaOriginal.size() - 1; i++) {
			if (!achou(semRepeticoes, listaOriginal.get(i), 0)) {
				semRepeticoes.add(listaOriginal.get(i));
			}
		}

		return semRepeticoes;

	}

	public static List<Integer[]> geraListaDeCombinacoes(
			Integer[] numerosEscolhidos, List<Integer[]> combinacoesAuxiliares) {

		List<Integer[]> novaListaDeCombinacoes = new ArrayList<Integer[]>();

		System.out.print("+");

		for (int i = 0; i < numerosEscolhidos.length; i++) {

			for (int j = 0; j < combinacoesAuxiliares.size(); j++) {

				Integer[] combinacaoAtual = combinacoesAuxiliares.get(j);
				
				if (Arrays.binarySearch(combinacaoAtual, numerosEscolhidos[i]) >= 0) {
					continue;
				}

				int tamanho = combinacaoAtual.length + 1;

				Integer[] novaCombinacao = new Integer[tamanho];

				novaCombinacao[0] = numerosEscolhidos[i];

				for (int k = 0; k < combinacaoAtual.length; k++) {

					novaCombinacao[k + 1] = combinacaoAtual[k];

				}

				Arrays.sort(novaCombinacao);
				
				if (achou(novaListaDeCombinacoes, novaCombinacao, 0)) {
					continue;
				}
				
				novaListaDeCombinacoes.add(novaCombinacao);

				// System.out.print(novaListaDeCombinacoes.size() + " "); 

			}

		}

		// System.out.println(); 
		return novaListaDeCombinacoes;

	}

}
