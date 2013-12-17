package br.com.caelum.desconto;

import br.com.caelum.orcamento.Orcamento;

public interface Desconto {
	double desconta(Orcamento orcamento);
	void setProximo(Desconto proximoDesconto);
}