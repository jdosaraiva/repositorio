package br.com.caelum.relatorio;

public abstract class TemplateDeRelatorio {
	
	protected Banco banco;
	
	public void imprimeRelatorio() {
		imprimeCabecalho();
		imprimeDetalhes();
		imprimeRodape();
	}
	
	protected abstract void imprimeCabecalho();

	protected abstract void imprimeDetalhes();

	protected abstract void imprimeRodape();

	protected void setBanco(Banco banco) {
		this.banco = banco;
	}
}
