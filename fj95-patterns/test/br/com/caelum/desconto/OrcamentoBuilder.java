package br.com.caelum.desconto;

import br.com.caelum.orcamento.Item;
import br.com.caelum.orcamento.Orcamento;

public class OrcamentoBuilder {
	
	private Orcamento orc;
	
	public OrcamentoBuilder(double valor) {
		this.orc = new Orcamento(valor);
	}
	
	public OrcamentoBuilder comItem(String nome, double valor) {
		this.orc.getItens().add(new Item(nome, valor));
		return this;
	}
	
	public Orcamento constroi() {
		return this.orc;
	}
	

}
