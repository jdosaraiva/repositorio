package br.com.caelum.desconto;

import br.com.caelum.orcamento.Orcamento;

public class CalculadorDeDescontos {
	public double calcula(Orcamento orcamento) {
		Desconto d1 = new DescontoPorCincoItens();
		Desconto d2 = new DescontoPorMaisDeQuinhentosReais();

		d1.setProximo(d2);

		return d1.desconta(orcamento);
	}
}
