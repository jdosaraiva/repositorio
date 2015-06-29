package br.com.saraiva.ocpjava;

import java.util.Scanner;
import java.util.Locale;

// br.com.saraiva.ocpjava.ScanX
// br\com\saraiva\ocpjava\ScanX.java
public class ScanX {
	public static void main(String[] args) {
		
		System.out.println("Locale:" + Locale.getDefault()); 
		Locale locBR = new Locale("pt", "BR");
		Locale.setDefault(locBR);
		System.out.println("Locale:" + Locale.getDefault()); 
		
		if (args.length < 2) {
			System.out.println("Uso: java ScanX <todo> <delimitador>");
			System.exit(1);
		}
		
		String todo = args[0];
		String delimitador = args[1];
		
		Scanner scan = new Scanner(todo);
		scan.useDelimiter(delimitador);
		
		while (scan.hasNext()) {
			System.out.println("Peda\u00e7o:[" + scan.next() +"]");
		}
		
		
		System.exit(0);
	}
}