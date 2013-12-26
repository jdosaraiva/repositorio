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
	
	public ConferidorDeLoteria(String dezenasSorteadas) {
		this.dezenasSorteadas = dezenasSorteadas.split(" ");
	}

	public boolean premiado(String[] jogo) { 
		return premiado( jogo, null);
	}

	public boolean premiado(String[] jogo, PrintWriter pw) {
		
		int acertos = 0;
		String strAcertos = "";
		
		for (String dezena : jogo) {
			for (int i = 0; i < dezenasSorteadas.length; i++) {
				if (dezena.equals(dezenasSorteadas[i])) {
					acertos++;
					strAcertos = strAcertos.concat(dezenasSorteadas[i]).concat(" ");
				}
			}
		}
		
		if (acertos > 10) {
			System.out.print("Jogo:[ ");
			if (pw != null) pw.printf("Número de Arcertos:[%d] - ", acertos, strAcertos);

			if (pw != null) pw.print("Jogo:[ ");
			
			for (String dezena : jogo) {
				System.out.printf("%s ", dezena);
				if (pw != null) pw.printf("%s ", dezena);
			}
			
			System.out.printf("] - Número de Arcertos:[%d]; Acertos:[%s]\n", acertos, strAcertos);
			if (pw != null) pw.printf("] - Acertos:[ %s]\n", strAcertos);

			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		ConferidorDeLoteria cl = new ConferidorDeLoteria("01 02 05 06 07 09 12 14 15 17 18 21 22 24 25");
		
		String fileName = "C:\\Temp\\combinacoes201312261407.txt";
		
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
		File arquivo = new File("c:\\temp\\conferindo" + sdf.format(GregorianCalendar.getInstance().getTime()) + ".txt");
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(arquivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		for (String string : aux) {
			String aposta = string.replaceAll("\r", "").trim();
			String[] dezenasApostadas = aposta.split(" ");
			cl.premiado(dezenasApostadas, pw);
		}

		
		pw.close();
		
		System.out.println("===============");
	}
}
