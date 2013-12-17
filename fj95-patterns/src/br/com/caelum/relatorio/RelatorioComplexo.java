package br.com.caelum.relatorio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.caelum.conta.Conta;

public class RelatorioComplexo extends TemplateDeRelatorio {

	@Override
	public void imprimeCabecalho() {
		System.out.printf("\n\n%.72s\n", banco.getNomeBanco());
		System.out.printf("Endereco: %.62s\n", banco.getEndereco());
		System.out.printf("Telefone: %.62s\n", banco.getTelefone());
		System.out.println("\n========================================================================");
	}

	@Override
	public void imprimeDetalhes() {
		
		if (banco.getContas().size() > 0) {
			System.out.printf("%-25s %-20.20s %10s %14s\n", "Titular", "Agência", "Conta", "Saldo");
			System.out.println("------------------------------------------------------------------------");
		}
		
		for (Conta conta : banco.getContas()) {
			System.out.printf("%-25s %-20.20s %10d %,14.2f\n", conta.getNome(), conta.getAgencia(), conta.getNumero(), conta.getSaldo());
		}

	}

	@Override
	public void imprimeRodape() {
		
		Calendar cal = GregorianCalendar.getInstance();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("========================================================================");
		System.out.printf("\nE-mail: %-44.44s %s", banco.getEmail(), df.format(cal.getTime()));
	}

}
