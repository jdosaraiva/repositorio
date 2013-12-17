package br.com.caelum.desconto;

import br.com.caelum.orcamento.Orcamento;

public class SemDesconto implements Desconto {

	@Override
	public double desconta(Orcamento orcamento) {
		return 0;
	}

	@Override
	public void setProximo(Desconto proximoDesconto) {

	}

}
