package br.com.caelum.notafiscal;

public class NotaFiscalDao implements AcaoAposGerarNota {

	@Override
	public void executa(NotaFiscal notaFiscal) {
		System.out.println("Salvando nota no banco de dados.");
	}

}
