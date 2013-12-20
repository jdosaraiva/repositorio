package br.com.saraiva.combinacoes;

import java.util.ArrayList;
import java.util.List;

public class Brincadeira {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Integer> l = new ArrayList<Integer>();
		
		int tamanho = 3;
		
		for (int i = 1; i < 11; i++) {
			l.add(i);
		}

		for (Integer a : l) {
			System.out.printf("%02d ", a);
		}
		System.out.println();
		
		for (int i = 0; i < l.size() - tamanho + 1; i++) {
			for (int j = i; j < (i+tamanho); j++) {
				System.out.printf("%02d ", l.get(j));
			}
			System.out.println();
		}
		
	}
	
}
