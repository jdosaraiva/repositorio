package br.com.caelum.notafiscal;

public class EnviadorDeSms implements AcaoAposGerarNota {

	@Override
	public void executa(NotaFiscal notaFiscal) {
		System.out.println("Enviando nota por SMS");
	}

}
