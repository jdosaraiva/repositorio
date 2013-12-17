package br.com.caelum.conta;

public class SemResposta extends Resposta {

	@Override
	public String devolveConta(Conta conta, Requisicao requisicao) {
		return null;
	}

	@Override
	public void setProxima(Resposta proxima) {
		// não tem

	}

}