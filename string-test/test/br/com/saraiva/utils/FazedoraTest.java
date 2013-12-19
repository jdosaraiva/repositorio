package br.com.saraiva.utils;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class FazedoraTest {

	@Test
	public void deveChamarOMetodoFazAlgumaCoisa() {

		Fazedora mock = mock(Fazedora.class);

		mock.fazAlgumaCoisa();

		verify(mock).fazAlgumaCoisa();

	}

}
