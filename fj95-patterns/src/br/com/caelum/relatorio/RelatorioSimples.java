package br.com.caelum.relatorio;

import br.com.caelum.conta.Conta;

public class RelatorioSimples extends TemplateDeRelatorio {

	@Override
	public void imprimeCabecalho() {
		System.out.printf("\n\n%-40.40s\n", banco.getNomeBanco());
		System.out.println("========================================");
	}

	@Override
	public void imprimeDetalhes() {
		
		if (banco.getContas().size() > 0) {
			System.out.printf("%-25s %14s\n", "Titular", "Saldo");
			System.out.println("----------------------------------------");
		}
		
		for (Conta conta : banco.getContas()) {
			System.out.printf("%-25s %,14.2f\n", conta.getNome(), conta.getSaldo());
		}

	}

	@Override
	public void imprimeRodape() {
		System.out.println("----------------------------------------");
		System.out.println("Telefone: " + banco.getTelefone());
	}

}
