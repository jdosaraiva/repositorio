package br.com.caelum.notafiscal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class NotaFiscalBuilderTest {

	/**
	 * 
	 */
	@Test
	public void deveExecutarAsAcoesAposGerarNota() {

		EnviadorDeEmail enviadorDeEmail = mock(EnviadorDeEmail.class);
		NotaFiscalDao notaFiscalDao = mock(NotaFiscalDao.class);
		Multiplicador multiplicador = mock(Multiplicador.class);

		List<AcaoAposGerarNota> acoes = new ArrayList<AcaoAposGerarNota>();
		acoes.add(enviadorDeEmail);
		acoes.add(notaFiscalDao);
		acoes.add(multiplicador);

		NotaFiscalBuilder builder = new NotaFiscalBuilder(acoes);

		NotaFiscal notaFiscal = builder.paraEmpresa("Caelum")
				.comCNPJ("123.456.789/0001-10")
				.comItem(new ItemDaNota("item 1", 100.0))
				.comItem(new ItemDaNota("item 2", 200.0))
				.comItem(new ItemDaNota("item 3", 300.0))
				.comObservacoes("entregar nota fiscal pessoalmente")
				.naDataAtual()
				.constroi();

		verify(enviadorDeEmail).executa(notaFiscal);
		verify(notaFiscalDao).executa(notaFiscal);
		verify(multiplicador).executa(notaFiscal);

	}

}
