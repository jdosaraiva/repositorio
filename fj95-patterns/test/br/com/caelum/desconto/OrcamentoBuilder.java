package br.com.caelum.desconto;

import br.com.caelum.orcamento.Item;
import br.com.caelum.orcamento.Orcamento;

public class OrcamentoBuilder {
	
	private Orcamento orc;
	
	public OrcamentoBuilder(Orcamento orcamento) {
		this.orc = orcamento;
	}
	
	public OrcamentoBuilder addItem(Item item) {
		this.orc.getItens().add(item);
		return this;
	}
	
	public Orcamento constroi() {
		return this.orc;
	}
	

}
