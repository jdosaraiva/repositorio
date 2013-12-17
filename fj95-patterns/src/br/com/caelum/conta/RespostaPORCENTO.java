package br.com.caelum.conta;

public class RespostaPORCENTO extends Resposta {
	
	public RespostaPORCENTO(Resposta proxima) {
		this.proxima = proxima;
	}

	@Override
	public String devolveConta(Conta conta, Requisicao requisicao) {
		StringBuilder strConta = new StringBuilder();
		
		if (Formato.PORCENTO.equals(requisicao.getFormato())) {
			strConta.append(conta.getNome());
			strConta.append("%");
			strConta.append(conta.getSaldo());
			return strConta.toString();
		} 
		
		return this.proxima.devolveConta(conta, requisicao);
		
	}

	@Override
	public void setProxima(Resposta proxima) {
		this.proxima = proxima;
	}

}