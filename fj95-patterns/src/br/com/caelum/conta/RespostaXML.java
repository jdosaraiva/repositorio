package br.com.caelum.conta;

public class RespostaXML extends Resposta {

	public RespostaXML(Resposta outraResposta) {
		this.proxima = outraResposta;
	}


	@Override
	public String devolveConta(Conta conta, Requisicao requisicao) {
		StringBuilder strConta = new StringBuilder();

		if (Formato.XML.equals(requisicao.getFormato())) {
			strConta.append("<xml>\n\t<conta>\n\t\t<nome>");
			strConta.append(conta.getNome());
			strConta.append("</nome>\n\t\t<saldo>");
			strConta.append(conta.getSaldo());
			strConta.append("</saldo>\n\t</conta>\n</xml>");
			return strConta.toString();
		}

		return this.proxima.devolveConta(conta, requisicao);
	}

	@Override
	public void setProxima(Resposta proxima) {
		this.proxima = proxima;
	}

}