package br.com.caelum.conta;

public class RespostaCSV extends Resposta {
	
	public RespostaCSV(Resposta proxima) {
		this.proxima = proxima;
	}

	@Override
	public String devolveConta(Conta conta, Requisicao requisicao) {
		StringBuilder strConta = new StringBuilder();

		if (Formato.CSV.equals(requisicao.getFormato())) {
			strConta.append(conta.getNome());
			strConta.append(",");
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
