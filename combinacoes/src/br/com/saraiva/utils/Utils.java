package br.com.saraiva.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;

public class Utils {

	public static String toStr(int[] iDezenas) {
		StringBuilder sb = new StringBuilder();
		DecimalFormat df = new DecimalFormat("00");
		for (int iDezena : iDezenas) {
			sb.append(df.format(iDezena)).append(" ");
		}
		String str = sb.toString().trim();
		return str;
	}

	public static int[] toIntArraySorted(String novaCombinacao) {
		String[] sDezenas = novaCombinacao.trim().split(" ");
		int[] iDezenas = new int[sDezenas.length];
		for (int i = 0; i < sDezenas.length; i++) {
			iDezenas[i] = Integer.parseInt(sDezenas[i]);
		}
		Arrays.sort(iDezenas);
		return iDezenas;
	}

	public static void imprimeMapa(Map<Integer, String> mapa) {
		for (Integer key : mapa.keySet()) {
			String entrada = mapa.get(key);
			System.out.printf("%s \n", entrada);
		}
		System.out.println("-- Tamanho do mapa:[" + mapa.size() + "]");
	}

	/**
	 * Grava um mapa num arquivo
	 * 
	 * @param mapa
	 *            a percorrer
	 * @param nomeArquivoSaida
	 *            nome do arquivo de saída
	 */
	public static void gravaMapaEmArquivo(Map<Integer, String> mapa,
			String nomeArquivoSaida) {

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

	/**
	 * Le o conteúdo de um arquivo pequeno e o coloca numa string
	 * 
	 * @param nomeArquivo
	 *            nome do arquivo para leitura
	 * @return uma String com o conteúdo do arquivo
	 */
	public static String leConteudoArquivo(String nomeArquivo) {
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
