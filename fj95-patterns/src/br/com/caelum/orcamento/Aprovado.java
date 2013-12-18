package br.com.caelum.orcamento;

public class Aprovado implements EstadoDeUmOrcamento {

	private boolean descontoAplicado = false;

	public void aplicaDescontoExtra(Orcamento orcamento) {
		if (!descontoAplicado) {
			orcamento.valor -= orcamento.valor * 0.02;
			descontoAplicado = true;
		} else {
			throw new RuntimeException("Desconto já aplicado!");
		}
	}

	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Orçamento já está em estado de aprovação");
	}

	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("Orçamento está em estado de aprovação e não pode ser reprovado");
	}

	public void finaliza(Orcamento orcamento) {
		orcamento.estadoAtual = new Finalizado();
	}

}
