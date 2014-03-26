package br.com.saraiva.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class TestesAleatorios {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		
		System.out.println(sdf.format(GregorianCalendar.getInstance().getTime()));
		
		String fileName = "C:\\Temp\\combinacoes201312261006.txt";
		
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
		
		int posicao = conteudo.indexOf("01 03 04 05 06 07 08 09 10 11 12 13 14 15 16");
		
		System.out.println("Posicao:[" + posicao + "]");

		String[] aux = conteudo.split("\n");
		
		for (String string : aux) {
			System.out.printf("%s\n", string.replaceAll("\r", ""));
		}
	}

}
