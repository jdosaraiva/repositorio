package br.com.caelum.orcamento;

public class Reprovado implements EstadoDeUmOrcamento {

	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		throw new RuntimeException("Orçamentos reprovados não recebem desconto extra!");
	}

	@Override
	public void aprova(Orcamento orcamento) {
		// nao pode ser reprovado agora!
		throw new RuntimeException("Orçamento está em estado reprovado e não pode ser aprovado");
	}

	@Override
	public void reprova(Orcamento orcamento) {
		// nao pode ser reprovado agora!
		throw new RuntimeException("Orçamento já está reprovado");
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		// daqui posso ir para o estado de finalizado
		orcamento.estadoAtual = new Finalizado();
	}

}
