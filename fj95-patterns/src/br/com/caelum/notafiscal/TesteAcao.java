package br.com.caelum.notafiscal;

import java.util.ArrayList;
import java.util.List;

public class TesteAcao {
	public static void main(String[] args) {
		List<AcaoAposGerarNota> acoes = new ArrayList<AcaoAposGerarNota>();
		acoes.add(new EnviadorDeEmail());
		acoes.add(new NotaFiscalDao());
		acoes.add(new Multiplicador(2));

		NotaFiscalBuilder builder = new NotaFiscalBuilder(acoes);

		NotaFiscal notaFiscal = builder.paraEmpresa("Caelum")
				.comCNPJ("123.456.789/0001-10")
				.comItem(new ItemDaNota("item 1", 100.0))
				.comItem(new ItemDaNota("item 2", 200.0))
				.comItem(new ItemDaNota("item 3", 300.0))
				.comObservacoes("entregar nota fiscal pessoalmente")
				.naDataAtual()
				.constroi();
	}
}
