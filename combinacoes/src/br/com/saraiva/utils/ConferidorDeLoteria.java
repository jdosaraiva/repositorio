package br.com.saraiva.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class ConferidorDeLoteria {

	private String[] dezenasSorteadas = null;
	private int[] numAcertos = new int[4]; 

	public ConferidorDeLoteria(String dezenasSorteadas) {
		this.dezenasSorteadas = dezenasSorteadas.split(" ");
	}

	public boolean premiado(String[] jogo) {
		return premiado(jogo, null);
	}

	public boolean premiado(String[] jogo, PrintWriter pw) {

		int acertos = 0;
		String strAcertos = "";

		outerloop : for (String dezena : jogo) {
			for (int i = 0; i < dezenasSorteadas.length; i++) {
				// System.out.println(" " + dezena + " == " + dezenasSorteadas[i].trim() + " - " + dezena.equals(dezenasSorteadas[i]));
				if (dezena.trim().equals(dezenasSorteadas[i].trim())) {
					acertos++;
					strAcertos = strAcertos.concat(dezenasSorteadas[i].trim()).concat(" ");
					continue outerloop;
				}
			}
		}

		if (acertos > 10) {
			
			numAcertos[acertos-11] = numAcertos[acertos-11] + 1; 
			
			System.out.print("Jogo:[ ");
			if (pw != null)
				pw.printf("Número de Arcertos:[%d] - ", acertos);

			if (pw != null)
				pw.print("Jogo:[ ");

			for (String dezena : jogo) {
				System.out.printf("%s ", dezena);
				if (pw != null)
					pw.printf("%s ", dezena);
			}

			System.out.printf("] - Número de Arcertos:[%d]; Acertos:[%s]\n",
					acertos, strAcertos);
			if (pw != null)
				pw.printf("] - Acertos:[ %s]\n", strAcertos);

			return true;
		}

		return false;
	}

	public static void main(String[] args) {

		Lotofacil lf = new Lotofacil();
		
		ConferidorDeLoteria cl = new ConferidorDeLoteria("01 02 05 06 07 09 12 14 15 17 18 21 22 24 25");
		if (args.length > 0) {
			cl = new ConferidorDeLoteria(lf.leConteudoArquivo(args[0]));
		}
		System.out.println("Dezenas Sorteadas:[" + cl + "]");

		String fileName = "C:\\Temp\\combinacoes201312261407.txt";
		if (args.length > 1) {
			fileName = args[1];
		}

		RandomAccessFile f;

		byte[] b = null;

		try {
			f = new RandomAccessFile(fileName, "r");
			b = new byte[(int) f.length()];
			f.read(b);
			f.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String conteudo = new String(b);

		String[] aux = conteudo.split("\n");

		System.out.println("===============");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		File arquivo = new File("c:\\temp\\conferindo"
				+ sdf.format(GregorianCalendar.getInstance().getTime())
				+ ".txt");
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(arquivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for (String string : aux) {
			String aposta = string.replaceAll("\r", "").trim();
			System.out.println("Aposta:[" + aposta + "]");
			String[] dezenasApostadas = aposta.split(" ");
			cl.premiado(dezenasApostadas, pw);
		}

		pw.close();

		System.out.println("===============");
		cl.trataNumAcertos();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String dezena : this.dezenasSorteadas) {
			sb.append(dezena).append(" ");
		}
		return sb.toString().trim();
	}
	
	public void trataNumAcertos() {
		
		for (int i = 0; i < numAcertos.length; i++) {
			if (numAcertos[i] > 0) {
				double multiplicador = i == 0 ? 2.5 : i == 1 ? 5.0 : 12.5; 
				double valor = numAcertos[i] * multiplicador;
				System.out.printf("Apostas com %d acertos:[%03d] - Valor:[%.2f]\n", (i+11), numAcertos[i], valor);
			}
		}
	}
}
