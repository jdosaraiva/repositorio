package br.com.caelum.desconto;

import br.com.caelum.orcamento.Orcamento;
public class DescontoPorCincoItens implements Desconto {

	private Desconto proximo;

	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}

	public double desconta(Orcamento orcamento) {
		if (orcamento.getItens().size() > 5) {
			return orcamento.getValor() * 0.1;
		} else {
			return proximo.desconta(orcamento);
		}
	}
}