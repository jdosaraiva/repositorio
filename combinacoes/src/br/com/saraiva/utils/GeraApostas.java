package br.com.saraiva.utils;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class GeraApostas {

	public static void main(String[] args) {
		
		if (args.length < 2) {
			System.out.println("Uso: java br.com.saraiva.utils.GeraApostas <arquivo de combinacoes> <numero de apostas>");
			System.exit(1);
		}
		
		String nomeArquivo = args[0];
		int numeroDeApostas = Integer.parseInt(args[1]);

		String aux = Utils.leConteudoArquivo(nomeArquivo);
		String[] combinacoes = aux.split("\n");
		
		double numLinhas = Math.ceil(combinacoes.length / (numeroDeApostas - 1));
		
		System.out.println("Combinacoes no arquivo:[" + combinacoes.length + "]");

		int posAtual = 1;
		
		Map<Integer, String> mapa = new HashMap<Integer, String>();
		
		for (int i = 0; i < numeroDeApostas; i++) {
			posAtual = posAtual < combinacoes.length ? posAtual : combinacoes.length - 1;
			System.out.println(combinacoes[posAtual].replace("\r", ""));
			String comb = combinacoes[posAtual].replace("\r", "").trim();
			mapa.put(comb.hashCode(), comb);
			posAtual += numLinhas;
		}
		
		DecimalFormat df = new DecimalFormat("00");
		String[] aux2 = nomeArquivo.split("\\\\");
		nomeArquivo = "C:\\Temp\\" +  df.format(numeroDeApostas) + "_DE_" + aux2[aux2.length - 1];
		System.out.println("Nome do arquivo de saida:[" + nomeArquivo + "]");
		Utils.gravaMapaEmArquivo(mapa, nomeArquivo);
		
		Map<Integer, String> outroMapa = new HashMap<Integer, String>();
		for (Integer key : mapa.keySet()) {
			String comb = mapa.get(key);
			aux2 = comb.split(" ");
			for (String string : aux2) {
				outroMapa.put(string.hashCode(), string);
			}
		}
		
		System.out.println("Quantidade de dezenas:[" + outroMapa.size() + "]");
		
		System.exit(0);
	}
}
