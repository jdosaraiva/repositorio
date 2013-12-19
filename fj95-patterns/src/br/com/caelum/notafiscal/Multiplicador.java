package br.com.caelum.notafiscal;

public class Multiplicador implements AcaoAposGerarNota {

	private double fator;
	
	public Multiplicador(double fator) {
		this.fator = fator;
	}
	
	@Override
	public void executa(NotaFiscal notaFiscal) {
		System.out.println("Valor da nota multiplicado:[" + notaFiscal.getValorBruto() * this.fator + "]");
	}

}
