package br.com.caelum.notafiscal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class NotaFiscalBuilder {

	private String razaoSocial;
	private String cnpj;
	private double valorTotal;
	private double impostos;
	private Calendar data;
	private String observacoes;

	private List<ItemDaNota> todosItens = new ArrayList<ItemDaNota>();
	
	public NotaFiscalBuilder() {
		this.data = GregorianCalendar.getInstance();
	}
	
	public NotaFiscalBuilder paraEmpresa(String empresa) {
		this.razaoSocial = empresa;
		return this;
	}

	public NotaFiscalBuilder comCNPJ(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}
	
	public NotaFiscalBuilder comItem(ItemDaNota item) {
		todosItens.add(item);
		valorTotal += item.getValor();
		impostos += item.getValor() * 0.05; 
		return this;
	}
	
	public NotaFiscalBuilder comObservacoes(String observacoes) {
		this.observacoes = observacoes;
		return this;
	}
	
	public NotaFiscalBuilder naDataAtual() {
		this.data = GregorianCalendar.getInstance();
		return this;
	}
	
	public NotaFiscalBuilder naData(Calendar data) {
		this.data = data;
		return this;
	}
	
	public NotaFiscal constroi() {
		return new NotaFiscal(razaoSocial, cnpj, data, valorTotal, impostos,
				todosItens, observacoes);
	}
	
}
