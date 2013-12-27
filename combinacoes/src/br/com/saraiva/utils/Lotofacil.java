package br.com.saraiva.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lotofacil {

	public static void main(String[] args) {

		Lotofacil lf = new Lotofacil();

//		String conteudoArquivo = lf.leConteudoArquivo("c:\\temp\\lotofacil.txt");
//
//		Map<Integer, String> mapa = lf.trataConteudo(conteudoArquivo);
//
//		System.out.println("Tamanho do mapa:[" + mapa.size() + "]");
//
//		lf.gravaMapaEmArquivo(mapa, "c:\\temp\\lotofacil_2.txt");
		
		lf.compararaTodosOsResultadosComMinhasApostas("C:\\Temp\\16_DE_18_combinacoes201312261425.txt");
	}

	/**
	 * Compara todos os resultadados da Lotofacil com um arquivo de apostas
	 * @param arquivoApostas arquivo com apostas
	 */
	private void compararaTodosOsResultadosComMinhasApostas(String arquivoApostas) {
		
		System.out.println("Iniciando comparação...");

		boolean temPremiado = false;
		
		String s1 = this.leConteudoArquivo("c:\\temp\\lotofacil_2.txt");
		String s2 = this.leConteudoArquivo(arquivoApostas);

		Map<Integer, String> todos = this.trataConteudo(s1);
		Map<Integer, String> meus = this.trataConteudo(s2);
		
		for (Integer chave : meus.keySet()) {
			if (todos.containsKey(chave)) {
				System.out.println("Jogo:[" + todos.get(chave) + "] já foi premiado.");
				temPremiado = true;
			}
		}
		
		for (Integer chave : todos.keySet()) {
			ConferidorDeLoteria cl = new ConferidorDeLoteria(todos.get(chave));
			for (Integer aposta : meus.keySet()) {
				String[] aux = meus.get(aposta).split(" ");
				cl.premiado(aux);
			}
		}
		
		if (!temPremiado) {
			System.out.println("Nenhuma das apostas deste arquivo já fez os 15 pontos.");
		}
		
	}

	@SuppressWarnings("unused")
	private void gravaMapaEmArquivo(Map<Integer, String> mapa, String nomeArquivoSaida) {

		FileWriter arq;
		try {
			arq = new FileWriter(nomeArquivoSaida);
			PrintWriter gravarArq = new PrintWriter(arq);

			for (Integer chave : mapa.keySet()) {
				String resultado = mapa.get(chave);
				gravarArq.println(resultado);
			}

			gravarArq.close();
			arq.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private Map<Integer, String> trataConteudo(String conteudoArquivo) {

		String[] conteudo = conteudoArquivo.split("\n");

		Map<Integer, String> mapa = new HashMap<Integer, String>();

		for (String linha : conteudo) {
			String aux = linha.replaceAll("\r", "");

			// System.out.println("> " + aux);

			int[] resultado = paraArrayInt(aux);

			String sResultado = paraStr(resultado);

			// System.out.println("< " + sResultado);

			mapa.put(sResultado.hashCode(), sResultado);
		}

		return mapa;
	}

	private String paraStr(int[] old) {
		StringBuilder sb = new StringBuilder();

		DecimalFormat df = new DecimalFormat("00");

		for (int i : old) {
			sb.append(df.format(i)).append(" ");
		}

		return sb.toString().trim();
	}

	private static int[] paraArrayInt(String origem) {

		String[] bolas = origem.split(" ");

		int[] numeros = new int[bolas.length];

		for (int i = 0; i < bolas.length; i++) {
			numeros[i] = Integer.parseInt(bolas[i]);
		}

		Arrays.sort(numeros);

		return numeros;
	}

	private String leConteudoArquivo(String nomeArquivo) {
		String conteudoArquivo = null;
		try {
			File filename = new File(nomeArquivo);
			RandomAccessFile raf = new RandomAccessFile(filename, "r");
			byte[] b = new byte[(int) raf.length()];
			raf.read(b);
			raf.close();

			conteudoArquivo = new String(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return conteudoArquivo;
	}

}
