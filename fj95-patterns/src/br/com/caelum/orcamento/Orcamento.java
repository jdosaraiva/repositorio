package br.com.caelum.orcamento;

import java.util.ArrayList;
import java.util.List;

public class Orcamento {

	protected EstadoDeUmOrcamento estadoAtual;

	protected double valor;
	private List<Item> itens;

	public Orcamento(double valor) {
		this.valor = valor;
		this.itens = new ArrayList<Item>();
		this.estadoAtual = new EmAprovacao();
	}

	public double getValor() {
		return valor;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void adicionaItem(Item item) {
		itens.add(item);
	}

	public void aplicaDescontoExtra() {
		estadoAtual.aplicaDescontoExtra(this);
	}

	public void aprova() {
		estadoAtual.aprova(this);
	}

	public void reprova() {
		estadoAtual.reprova(this);
	}

	public void finaliza() {
		estadoAtual.finaliza(this);
	}
}