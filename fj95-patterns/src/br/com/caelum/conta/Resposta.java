package br.com.caelum.conta;

public abstract class Resposta {

	protected Resposta proxima;
	
	public abstract String devolveConta(Conta conta, Requisicao requisicao);

	public abstract void setProxima(Resposta proxima);
	
}
