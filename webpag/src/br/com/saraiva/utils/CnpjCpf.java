package br.com.saraiva.utils;

import java.util.Random;

public class CnpjCpf {

	/*** Base de cálculo do dígito verificador. */
	private static final int BASE_CALCULO = 10;

	/*** Módulo 11. */
	private static final int MODULO = 11;

	/*** Limite de multiplicador para o cálculo do CPF. */
	private static final int LIMITE_MULT_CPF = 11;

	/*** Limite de multiplicador para o cálculo do CNPJ. */
	private static final int LIMITE_MULT_CNPJ = 9;

	/*** Posição do dígito verificador do CPF. */
	private static final int POSICAO_DIGITO_VERIFICADOR_CPF = 9;

	/*** Posição do dígito verificador do CNPJ. */
	private static final int POSICAO_DIGITO_VERIFICADOR_CNPJ = 12;

	/** Minuto visita */
	private static String minutoVisitaStr = "minutoVisita";

	/**
	 * Calcula o dígito verificador do número de inscrição
	 * 
	 * @param unmaskedValue
	 *            Número da incrição a ser validada, sem o dígito verificador
	 * @param indicadorCPF
	 *            Indica se é o digito verificador de um CPF ou não no caso de
	 *            ser um CNPJ
	 * @return Dígito verificador calculado
	 */

	public static String calculaDigitoVerificador(

	final String unmaskedValue, final boolean indicadorCPF) {

		int soma = 0;
		int mult = 0;
		int limiteMult = LIMITE_MULT_CPF;
		String inscricao = unmaskedValue;

		// Se não for CPF o limite vai para 9 no caso de CNPJ
		if (!indicadorCPF) {
			limiteMult = LIMITE_MULT_CNPJ;
		}

		for (int t = 1; t <= 2; t++) {

			soma = 0;
			mult = 2;
			int maxloop = inscricao.length();

			for (int j = maxloop; j > 0; j--) {
				soma += (mult * Integer.parseInt(inscricao.substring(j - 1, j)));
				mult += 1;
				if (mult > limiteMult) {
					mult = 2;
				}

			}

			inscricao += String.valueOf((((soma * BASE_CALCULO) % MODULO) % BASE_CALCULO));

		}

		return inscricao.substring(inscricao.length() - 2, inscricao.length());

	}

	
	public static void main(String[] args) {
		
		Random r = new Random();
		
		for (int i = 0; i < 10; i++) {
			if (r.nextBoolean()) {
				System.out.println(geraCnpj());
			} else {
				System.out.println(geraCpf());
			}
		}
		
	}
	
	
	public static String geraCnpj() {
		
		Random r = new Random();
		int n1, n2, n3;
		n1 = r.nextInt(100);
		n2 = r.nextInt(1000);
		n3 = r.nextInt(1000);
		
		StringBuilder sb = new StringBuilder();
		sb.append(ajustaComZeros(String.valueOf(n1), 2));
		sb.append(ajustaComZeros(String.valueOf(n2), 3));
		sb.append(ajustaComZeros(String.valueOf(n3), 3));
		sb.append("0001");
		String dv = calculaDigitoVerificador(sb.toString(), false);
		sb.append(dv);
		
		return formataCnpj(sb.toString());
	}
	
	public static String geraCpf() {
		
		Random r = new Random();
		int n1, n2, n3;
		n1 = r.nextInt(1000);
		n2 = r.nextInt(1000);
		n3 = r.nextInt(1000);
		
		StringBuilder sb = new StringBuilder();
		sb.append(ajustaComZeros(String.valueOf(n1), 3));
		sb.append(ajustaComZeros(String.valueOf(n2), 3));
		sb.append(ajustaComZeros(String.valueOf(n3), 3));
		String dv = calculaDigitoVerificador(sb.toString(), true);
		sb.append(dv);
		
		return formataCpf(sb.toString());
	}

	public static String ajustaComZeros(String numero, int tamanho) {
		StringBuilder sb = new StringBuilder(numero);
		while (sb.length() < tamanho) {
			sb.insert(0, '0');
		}
		return sb.toString();
	}
	
	public static String formataCnpj(String cnpj) {
		StringBuilder sb = new StringBuilder(cnpj);
		sb.insert(2, '.').insert(6, '.').insert(10, '/').insert(15, '-');
		
		return sb.toString();
	}
	
	public static String formataCpf(String cpf) {
		StringBuilder sb = new StringBuilder(cpf);
		sb.insert(3, '.').insert(7, '.').insert(11, '-');
		
		return sb.toString();
	}
	
}
