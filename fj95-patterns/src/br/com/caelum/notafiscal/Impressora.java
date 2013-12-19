package br.com.caelum.notafiscal;

public class Impressora implements AcaoAposGerarNota {

	@Override
	public void executa(NotaFiscal notaFiscal) {
		System.out.println("Imprimindo Nota Fiscal");
	}

}
