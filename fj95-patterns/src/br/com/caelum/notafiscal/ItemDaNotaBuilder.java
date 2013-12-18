package br.com.caelum.notafiscal;

public class ItemDaNotaBuilder {

	String descricao;
	double valor;
	
	public ItemDaNotaBuilder comDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}
	
	public ItemDaNotaBuilder comValor(double valor) {
		this.valor = valor;
		return this;
	}
	
	public ItemDaNota constroi() {
		return new ItemDaNota(this.descricao, this.valor);
	}
	
}
